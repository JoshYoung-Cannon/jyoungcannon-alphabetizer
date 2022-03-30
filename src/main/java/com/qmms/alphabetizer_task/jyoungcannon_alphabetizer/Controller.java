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
	
	public boolean run() {
		boolean running = true, validFileLocation = false, iOError;
		FileIO fIO = new FileIO();
		ArrayList<String> rawData = new ArrayList<String>(); 
		System.out.println("Welcome to the Text File Alphabetizer by Josh Young-Cannon!");
		System.out.println("You can exit this application by typing QUIT at any time you are asked to type an input.");
		while (running) {
			while (!validFileLocation) {
				iOError = false;
				// 1 - Ask for file location - provide option to quit
				running = askFileLocation();
				if (!running) {
					break;
				}
				// 2 - Get file data - if data file invalid return to step 1
				try {
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
			// 4 - Separate into words by space
			// 5 - Sort words into valid and invalid lists
			// 6 - Alphabetize valid words
			// 7 - Display results
			// 8 - Save results - if data file invalid ask user to provide alternative or quit
			// 9 - End script
		}
		System.out.println("Goodbye");
		return true;
	}
}
