package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.util.Scanner;

public class UserInput {
	
	public static String fileInput() {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter a file location:");

	    String strVal = scanner.nextLine();  // Read user input
		return strVal;
	}
}
