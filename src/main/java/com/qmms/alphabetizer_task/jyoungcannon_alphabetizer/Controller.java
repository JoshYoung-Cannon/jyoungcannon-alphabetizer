package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import com.qmms.alphabetizer_task.jyoungcannon_alphabetizer.file_input_output.FileIO;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
	
	private String inputFileLocation;
	private String outputFileLocation;
	private boolean running;
	private boolean read = true;
	private boolean write = false;
	
	private boolean askFileLocation(boolean reading) {
		String userInput;
		if (reading) {
			userInput = UserInput.fileInput("the full directory and file name of the text file to be sorted, in the format filepath\\filename.txt :");
		}
		else {
			userInput = UserInput.fileInput("the full directory of the folder you would like to save the results too:");
		}
		String userQuit = StringManipulator.wordToUpperCase(userInput);
		if (StringManipulator.stringEquals(userQuit, "QUIT")) {
			return false;
		}
		else {
			if (reading) {
				inputFileLocation = userInput;
			}
			else {
				outputFileLocation = userInput;
			}
			return true;
		}
	}
	
	private String[] arrayListToArray(ArrayList<String> arrayList) {
		String[] output = null;
		if (arrayList.size() > 0) {
			output = new String[arrayList.size()];
		}
		for (int i = 0; i < arrayList.size(); i++) {
			output[i] = arrayList.get(i);
		}
		return output;
	}
	
	private void printArray(String[] toPrint, String seperator) {
		for (int i = 0; i < toPrint.length; i++) {
			System.out.print(toPrint[i]);
			if (i != toPrint.length - 1) {
				System.out.print(seperator);
			}
			else {
				System.out.println();
			}
		}
	}
	
	private ArrayList<String> getInputFileLocation() {
		ArrayList<String> fileData = new ArrayList<String>();
		boolean validFileLocation = false, iOError = false;
		FileIO fIO = new FileIO();
		while (!validFileLocation) {
			// 1 - Ask for file location - provide option to quit
			running = askFileLocation(read);
			if (!running) {
				break;
			}
			// 2 - Get file data - if data file invalid return to step 1
			try {
				fileData.clear();
				fileData = fIO.loadDataThrowable(inputFileLocation);
			}
			catch (IOException e) {
				System.out.println("An IOException error has occured: " + inputFileLocation + " (The system cannot find the path specified)");
				System.out.println("Please ensure that the file and all folders in the file path exist");
				iOError = true;
			}
			catch (Exception e) {
				System.out.println("Unidentified error has occured");
				running = false;
				break;
			}
			if (fileData.size() > 0) {
				validFileLocation = true;
			}
			else if (!iOError) {
				System.out.println("The file you have entered has no data.");
			}
		}
		return fileData;
	}
	
	private String[] getUniqueItems(String[] words) {
		ArrayList<String> uniqueWords = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (!uniqueWords.contains(words[i])) {
				uniqueWords.add(words[i]);
			}
		}
		return arrayListToArray(uniqueWords);
	}
	
	private void getOutputFileLocation(String[] sortedWords, String[] invalidWords) {
		boolean validFileLocation = false, iOError = false;
		char backslash = '\\';
		String inputfileNameBase, inputFileName, outputFilePath;
		String[] inputfileNameComponents, uniqueWords;
		FileIO fIO = new FileIO();
		while (!validFileLocation) {
			// 1 - Ask for file location - provide option to quit
			running = askFileLocation(write);
			if (!running) {
				break;
			}
			// 2 - Get file data results file
			inputfileNameBase = StringManipulator.removeDuplicateChars(inputFileLocation, backslash);
			inputfileNameComponents = StringManipulator.splitString(inputfileNameBase, backslash);
			inputFileName = inputfileNameComponents[inputfileNameComponents.length - 1];
			
			if (sortedWords == null) {
				sortedWords = new String[] {"There are no words to save in this file"};
			}
			if (invalidWords == null) {
				invalidWords = new String[] {"There are no words to save in this file"};
			}
			
			// Save sorted list
			outputFilePath = outputFileLocation + backslash + "SortedWordsOf" + inputFileName;
			validFileLocation = fIO.writeData(outputFilePath, sortedWords, false);
			if (!validFileLocation) {
				continue;
			}
		
			// Save unique words
			uniqueWords = getUniqueItems(sortedWords);
			outputFilePath = outputFileLocation + backslash + "UniqueSortedWordsOf" + inputFileName;
			validFileLocation = fIO.writeData(outputFilePath, uniqueWords, false);
			if (!validFileLocation) {
				continue;
			}
			
			// Save invalid list
			outputFilePath = outputFileLocation + backslash + "InvalidWordsOf" + inputFileName;
			validFileLocation = fIO.writeData(outputFilePath, invalidWords, false);
			if (!validFileLocation) {
				continue;
			}
		}
	}
	
	private void quitProgram() {
		String userInput = "";
		boolean validInput = false;
		while (!validInput) {
			userInput = StringManipulator.wordToUpperCase(UserInput.exitInput());
			switch (userInput) {
				case ("Y"):
					running = false;
					validInput = true;
					break;
				case ("YES"):
					running = false;
					validInput = true;
					break;
				case ("N"):
					validInput = true;
					break;
				case ("NO"):
					validInput = true;
					break;
				case ("QUIT"):
					running = false;
					validInput = true;
					break;
				default:
					break;
			}
		}
	}
	
	public boolean run() {
		boolean validFileLocation, iOError;
		char space = ' ';
		String rawString, formattedString;
		Validator valid = new Validator();
		ArrayList<String> rawData = new ArrayList<String>(); 
		ArrayList<String> validWords = new ArrayList<String>();
		ArrayList<String> invalidWords = new ArrayList<String>();
		
		running = true;
		System.out.println("Welcome to the Text File Alphabetizer by Josh Young-Cannon!");
		System.out.println("You can exit this application by typing QUIT at any time you are asked to type an input.");
		while (running) {
			rawData.clear();
			rawData = getInputFileLocation();
			if (rawData.size() > 0) {
				// 3 - Ensure only 1 space between each word
				rawString = rawData.get(0);
				if (rawData.size() > 1) {
					for (int i = 1; i < rawData.size(); i++) {
						rawString = rawString + " " + rawData.get(i);
					}
				}
				
				formattedString = StringManipulator.removeDuplicateChars(rawString, space);
				System.out.println("Input from file: " + formattedString);
				
				// 4 - Separate into words by space
				String[] allWords = StringManipulator.splitString(formattedString, space);
				
				// 5 - Sort words into valid and invalid lists
				validWords.clear();
				invalidWords.clear();
				for (int i = 0; i < allWords.length; i++) {
					if (valid.validateWord(allWords[i])) {
						validWords.add(allWords[i]);
					}
					else {
						invalidWords.add(allWords[i]);
					}
				}
				
				// 6 - Alphabetize valid words
				String[] wordsToSort = arrayListToArray(validWords);
				String[] result = null;
				if (validWords.size() > 0) {
					result = SortOptions.bubbleSortAlphabetically(wordsToSort);
				}
				String[] unsortedWords = arrayListToArray(invalidWords);
				
				// 7 - Display results
				System.out.println("Result:");
				System.out.print("Sorted Words:");
				if (validWords.size() > 0) {
					System.out.println();
					printArray(wordsToSort, "\n");
				}
				else {
					System.out.println(" There are no valid words from this input");
				}
				
				System.out.print("Invalid Words:");
				if (invalidWords.size() > 0) {
					System.out.println();
					printArray(unsortedWords, "\n");
				}
				else {
					System.out.println(" There are no invalid words from this input");
				}
				// 8 - Save results - if data file invalid ask user to provide alternative or quit
				getOutputFileLocation(result, unsortedWords);
				
				// 9 - End script
				quitProgram();
			}
		}
		System.out.println("Goodbye");
		return true;
	}
}
