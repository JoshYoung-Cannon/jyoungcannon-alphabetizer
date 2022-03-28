package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

public class SortOptions {
	
	/**
	 * @param a char from earlier item in list to be sorted 
	 * @param b char from later item in list to be sorted
	 * @return Returns true if items should be swapped alphabetically, false if not e.g. inputs ('Z','A') returns true, inputs ('A','Z') returns false
	 */
	private static boolean charCompareAlphabetically(char a, char b) {
		int aValue = a, aLower = a, bValue = b, bLower = b;
		
		// Both UpperCase || Both LowerCase
		if ((StringManipulator.isUpperCase(aValue) && StringManipulator.isUpperCase(bValue)) || (StringManipulator.isLowerCase(aValue) && StringManipulator.isLowerCase(bValue))) {
			
			if (aValue > bValue) {
				return true;
			}
		}
		else {
			// Convert to lower case
			if (StringManipulator.isUpperCase(aValue)) {
				aLower = StringManipulator.toLowerCase(aValue);
			}
			if (StringManipulator.isUpperCase(bValue)) {
				bLower = StringManipulator.toLowerCase(bValue);
			}
			
			// Are they the same char in different cases
			if (aLower == bLower) {
				// Upper case higher in the alphabet
				if (aValue > bValue) {
					return true;
				}
			}
			else {
				if (aLower > bLower) {
					return true;
				}
			}
		}
		// Default
		return false;
	}
	
	/**
	 * @param a Possibly hyphened string item earlier in the list to be sorted
	 * @param b Possibly hyphened string item later in the list to be sorted
	 * @return Returns true if items should be swapped alphabetically, false if not e.g. inputs ('Z-Z','Z-A') returns true, inputs ('A-Z','Z-Z') returns false
	 */
	private static boolean hyphenCompareAlphabetically(String a, String b) {
		int n, countA, countB;
		char hyphen = '-';
		boolean swap = false, identical = true;
		
		// Prep data
		String[] hyphenA = StringManipulator.splitString(a, hyphen);
		countA = StringManipulator.containsCount(a, hyphen) + 1; // +1 to get array size
		String[] hyphenB = StringManipulator.splitString(b, hyphen);
		countB = StringManipulator.containsCount(b, hyphen) + 1; // +1 to get array size
		
		// Identify how many comparisons are needed
		if (countA < countB) {
			n = countA;
		}
		else {
			n = countB;
		}
		
		for (int i = 0; i < n; i++) {
			if (!StringManipulator.stringEquals(hyphenA[i], hyphenB[i])) {
				swap = stringCompareAlphabetically(hyphenA[i], hyphenB[i]);
				identical = false;
				break;
			}
		}
		
		// if all compared words are identical, the larger list should be further down the sorted list
		if (identical && countA > countB) {
			swap = true;
		}
		return swap;
	}
	
	/**
	 * @param a The earlier string item in a list
	 * @param b The later string item in a list
	 * @return Returns true if items should be swapped alphabetically, false if not e.g. inputs ("Zy","Ab") returns true, inputs ("Ab","Zy") returns false
	 */
	private static boolean stringCompareAlphabetically(String a, String b) {
		int n, decisionChar = 0;
		boolean swap = false;
		// Convert to anglosized versions
		String angloA = StringManipulator.anglosizeString(a);
		String angloB = StringManipulator.anglosizeString(b);
		
		// Handle '-' words
		if (StringManipulator.containsCount(angloA, '-') > 0 || StringManipulator.containsCount(angloB, '-') > 0) {
			swap = hyphenCompareAlphabetically(angloA, angloB);
		}
		else {
			// Identify longer word
			if (angloA.length() < angloB.length()) {
				n = angloA.length();
			}
			else {
				n = angloB.length();
			}
			
			for (int i = 0; i < n; i++) {
				if (angloA.charAt(i) != angloB.charAt(i)) {
					swap = charCompareAlphabetically(a.charAt(i), b.charAt(i));
					decisionChar = i;
					break;
				}
			}
			// Shorter words are 1st alphabetically
			if (swap == false && a.length() > b.length() && !(StringManipulator.isUpperCase(angloA.charAt(decisionChar)) && StringManipulator.isLowerCase(angloB.charAt(decisionChar)))) {
				swap = true;
			}
		}
		
		return swap;
	}
	
	/**
	 * @param toSort String list containing all words to be sorted alphabetically
	 * @return A String list with all items in English-alphabetical order e.g. input ({"Fizz", "Buzz", "FizzBuzz"}) returns {"Buzz", "Fizz", "FizzBuzz"}
	 */
	public static String[] bubbleSortAlphabetically(String[] toSort) {
		String temp;
		boolean swap, swapNeeded;
		for (int i = 0; i < toSort.length - 1; i++) {
			swapNeeded = false;
			for (int j = 0; j < toSort.length - i - 1; j++) {
				swap = stringCompareAlphabetically(toSort[j], toSort[j + 1]);
				if (swap) {
					swapNeeded = true;
					temp = toSort[j+1];
					toSort[j+1] = toSort[j];
					toSort[j] = temp;
				}
			}
			
			// If swaps are no longer needed break to reduce wasted comparisons
			if (!swapNeeded) {
				break;
			}
		}
		return toSort;
	}
}
 