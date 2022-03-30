package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.util.Scanner;

public class UserInput {
	
	public static String fileInput(String message) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter " + message);

	    String strVal = scanner.nextLine();  // Read user input
		return strVal;
	}
	
	public static String exitInput() {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Would you like to exit the program: (Y/N) ");

	    String strVal = scanner.nextLine();  // Read user input
		return strVal;
	}
}
