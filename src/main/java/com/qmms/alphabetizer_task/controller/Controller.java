package com.qmms.alphabetizer_task.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.qmms.alphabetizer_task.input_output.FileIO;
import com.qmms.alphabetizer_task.input_output.UserInput;
import com.qmms.alphabetizer_task.sort_options.SortOptions;
import com.qmms.alphabetizer_task.string_interaction.StringManipulator;
import com.qmms.alphabetizer_task.string_interaction.Validator;


public class Controller {
	
	private String inputFileLocation;
	private String outputFileLocation;
	private boolean running;
	private boolean read = true;
	private boolean write = false;
	
	/**
	 * @param reading When true, this function asks for an input file location, when false, this function asks for a output file directory
	 * @return returns false when user decides to QUIT, otherwise returns true
	 */
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
	
	/**
	 * @param arrayList Arraylist to convert into an array
	 * @return An array containing all the items in the arraylist
	 */
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
	
	/**
	 * @param toPrint Array of values to print
	 * @param seperator The string used to space out the items e.g. , or -
	 */
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
	
	/**
	 * @return Arraylist of all the lines within a text file
	 */
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
	
	/**
	 * @param words Array containing duplicate items
	 * @return An array of unique items
	 */
	private String[] getUniqueItems(String[] words) {
		ArrayList<String> uniqueWords = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (!uniqueWords.contains(words[i])) {
				uniqueWords.add(words[i]);
			}
		}
		return arrayListToArray(uniqueWords);
	}
	
	/**
	 * @param sortedWords Array of words in alphabetical order
	 * @param invalidWords Array of invalid words
	 */
	private void getOutputFileLocation(String[] sortedWords, String[] invalidWords) {
		boolean validFileLocation = false;
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
	
	/**
	 * Asks the user if they would like to exit the program
	 */
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
	
	/**
	 * @return always returns true
	 */
	public boolean run() {
		char space = ' ';
		String rawString, formattedString;
		Validator valid = new Validator();
		ArrayList<String> rawData = new ArrayList<String>(); 
		ArrayList<String> validWords = new ArrayList<String>();
		ArrayList<String> invalidWords = new ArrayList<String>();
		
		// Start
		running = true;
		System.out.println("Welcome to the Text File Alphabetizer by Josh Young-Cannon!");
		System.out.println("You can exit this application by typing QUIT at any time you are asked to type an input.");
		while (running) {
			rawData.clear();
			rawData = getInputFileLocation();
			if (rawData.size() > 0) {
				
				// Convert multiple lines into a single line string
				rawString = rawData.get(0);
				if (rawData.size() > 1) {
					for (int i = 1; i < rawData.size(); i++) {
						rawString = rawString + " " + rawData.get(i);
					}
				}
				
				// Ensure only 1 space between each word
				formattedString = StringManipulator.removeDuplicateChars(rawString, space);
				System.out.println("Input from file: " + formattedString);
				
				// Separate input string into words by spaces
				String[] allWords = StringManipulator.splitString(formattedString, space);
				
				// Sort words into valid and invalid lists
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
				
				// Alphabetize valid words
				String[] wordsToSort = arrayListToArray(validWords);
				String[] result = null;
				if (validWords.size() > 0) {
					result = SortOptions.bubbleSortAlphabetically(wordsToSort);
				}
				String[] unsortedWords = arrayListToArray(invalidWords);
				
				// Display results
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
				
				// Save/don't save results
				getOutputFileLocation(result, unsortedWords);
				
				quitProgram();
			}
		}
		System.out.println("Goodbye");
		return true;
	}
}
