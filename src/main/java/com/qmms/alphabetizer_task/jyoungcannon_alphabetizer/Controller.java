package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import com.qmms.alphabetizer_task.jyoungcannon_alphabetizer.file_input_output.FileIO;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
	
	private String inputFileLocation;
	
	private boolean askFileLocation() {
		String userInput = UserInput.fileInput();
		String userQuit = StringManipulator.wordToUpperCase(userInput);
		if (StringManipulator.stringEquals(userQuit, "QUIT")) {
			return false;
		}
		else {
			inputFileLocation = userInput;
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
	
	public boolean run() {
		boolean running = true, validFileLocation, iOError;
		char space = ' ';
		String rawString, formattedString;
		FileIO fIO = new FileIO();
		Validator valid = new Validator();
		ArrayList<String> rawData = new ArrayList<String>(); 
		ArrayList<String> validWords = new ArrayList<String>();
		ArrayList<String> invalidWords = new ArrayList<String>();
		
		System.out.println("Welcome to the Text File Alphabetizer by Josh Young-Cannon!");
		System.out.println("You can exit this application by typing QUIT at any time you are asked to type an input.");
		while (running) {
			validFileLocation = false;
			while (!validFileLocation) {
				iOError = false;
				// 1 - Ask for file location - provide option to quit
				running = askFileLocation();
				if (!running) {
					break;
				}
				// 2 - Get file data - if data file invalid return to step 1
				try {
					rawData.clear();
					rawData = fIO.loadDataThrowable(inputFileLocation);
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
				if (rawData.size() > 0) {
					validFileLocation = true;
				}
				else if (!iOError) {
					System.out.println("The file you have entered has no data.");
				}
			}
			// 3 - Ensure only 1 space between each word
			rawString = rawData.get(0);
			if (rawData.size() > 1) {
				for (int i = 1; i < rawData.size(); i++) {
					rawString = rawString + " " + rawData.get(i);
				}
			}
			System.out.println("rawString: " + rawString);
			
			formattedString = StringManipulator.removeDuplicateChars(rawString, space);
			System.out.println("formattedString: " + formattedString);
			
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
			System.out.println("Words to sort:");
			printArray(wordsToSort, " ");
			
			String[] result = SortOptions.bubbleSortAlphabetically(wordsToSort);
			//String[] unsortedWords = (String[]) invalidWords.toArray();
			
			// 7 - Display results
			System.out.println("result:");
			printArray(wordsToSort, "\n");
			
			// 8 - Save results - if data file invalid ask user to provide alternative or quit
			
			// 9 - End script
		}
		System.out.println("Goodbye");
		return true;
	}
}
