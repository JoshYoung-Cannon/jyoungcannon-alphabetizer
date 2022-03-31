package com.qmms.alphabetizer_task.input_output;

import java.util.Scanner;

public class UserInput {
	
	/**
	 * Gets user input for filepaths
	 * @param message String to provide more detailed instruction to the user
	 * @return returns user input
	 */
	public static String fileInput(String message) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter " + message);

	    String strVal = scanner.nextLine();  // Read user input
		return strVal;
	}
	
	/**
	 * Gets user input for if they want to continue using the programme
	 * @return returns user input
	 */
	public static String exitInput() {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Would you like to exit the program: (Y/N) ");

	    String strVal = scanner.nextLine();  // Read user input
		return strVal;
	}
}
