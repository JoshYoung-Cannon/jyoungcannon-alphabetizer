package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.util.Scanner;

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
		boolean running = true, validFileLocation;
		System.out.println("Welcome to the Text File Alphabetizer by Josh Young-Cannon!");
		System.out.println("You can exit this application by typing QUIT at any time you are asked to type an input.");
		while (running) {
			
			// 1 - Ask for file location - provide option to quit
			running = askFileLocation();
			// 2 - Get file data - if data file invalid return to step 1
			// 3 - Ensure only 1 space between each word
			// 4 - Separate into words by space
			// 5 - Sort words into valid and invalid lists
			// 6 - Alphabetize valid words
			// 7 - Display results
			// 8 - Save results - if data file invalid ask user to provide alternative or quit
			// 9 - End script
		}
		return true;
	}
}
