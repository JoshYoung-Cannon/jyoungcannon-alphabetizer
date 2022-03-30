package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.util.Scanner;

public class UserInput {
	
	public static String fileInput() {
		Scanner scanner = new Scanner(System.in);
		String strVal = null;
		while (strVal == null) {
			strVal = scanner.nextLine();
			if (strVal.length() == 0) {
				System.out.println("Please enter a file location:");
				strVal = null;
			}
		}
		scanner.close();
		return strVal;
	}
	
	public static String strInput(int charLimit, String inputName) {
		Scanner scanner = new Scanner(System.in);
		String strVal = null;
		while (strVal == null) {
			strVal = scanner.nextLine().toUpperCase();
			if ((strVal.length() == 0) || (strVal.length() > charLimit)) {
				System.out.println("Please enter a " + inputName + " with 0-" + charLimit + " characters");
				strVal = null;
			}
		}
		scanner.close();
		return strVal;
	}

}
