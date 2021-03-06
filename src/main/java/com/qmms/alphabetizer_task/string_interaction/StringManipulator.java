package com.qmms.alphabetizer_task.string_interaction;

public class StringManipulator {
	
	/**
	 * upperCaseMin is the ascii value of A
	 * upperCaseMax is the ascii value of Z
	 * lowerCaseMin is the ascii value of a
	 * lowerCaseMax is the ascii value of z
	 * caseChange is the value needed to convert from one ascii value to another
	 */
	private static int upperCaseMin = 65;
	private static int upperCaseMax = 90;
	private static int lowerCaseMin = 97;
	private static int lowerCaseMax = 122;
	private static int caseChange = 32;
	
	/**
	 * Checks if a character is lower case
	 * @param a The char to test to see if it is a lower case character
	 * @return Returns true if input is a lower case alphabet character e.g. input ('g') returns true, input ('G') and ('!') returns false
	 */
	public static boolean isLowerCase(int a) {
		if (lowerCaseMin <= a && a <= lowerCaseMax) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a character is upper case
	 * @param a The char to test to see if it is a upper case character
	 * @return Returns true if input is a upper case alphabet character e.g. input ('G') returns true, input ('g') and ('!') returns false
	 */
	public static boolean isUpperCase(int a) {
		if (upperCaseMin <= a && a <= upperCaseMax) {
			return true;
		}
		return false;
	}
	
	/**
	 * Converts a character to lower case
	 * @param a The char to convert to lower case
	 * @return Returns the lower case equivalent of input a, if a is already lower case or not in the alphabet it returns the input e.g. input ('G') & input ('g') returns 'g', input ('!') returns '!'
	 */
	public static char toLowerCase(int a) {
		char output;
		if (isLowerCase(a) || !(isUpperCase(a))) {
			output = (char) a;
		}
		else {
			output = (char) (a + caseChange);
		}
		return output;
	}
	
	/**
	 * Converts a character to upper case
	 * @param a The char to convert to upper case
	 * @return Returns the upper case equivalent of input a, if a is already upper case or not in the alphabet it returns the input e.g. input ('G') & input ('g') returns 'G', input ('!') returns '!'
	 */
	public static char toUpperCase(int a) {
		char output;
		if (isUpperCase(a) || !(isLowerCase(a))) {
			output = (char) a;
		}
		else {
			output = (char) (a - caseChange);
		}
		return output;
	}
	
	public static String wordToUpperCase(String word) {
		String output = "";
		for (int i = 0; i < word.length(); i++) {
			output = output + toUpperCase(word.charAt(i));
		}
		return output;
	}

	/**
	 * Counts the amount of times a specific character occurs in a string
	 * @param sentence The string to iterate through
	 * @param splitChar The specific char to be looked for
	 * @return The number of time splitChar occurs in the given string
	 */
	public static int containsCount(String sentence, char splitChar) {
		int splitCharCount = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if ((int) sentence.charAt(i) == (int) splitChar) {
				splitCharCount += 1;
			}
		}
		return splitCharCount;
	}
	
	/**
	 * Copys a portion of a String based on the upper and lower bounds
	 * @param sentence The string to copy a subset from
	 * @param lowerBound The start char
	 * @param upperBound The end char
	 * @return The string subset defined by the upper & lower bound e.g. inputs ("FizzBuzz", 0, 5) returns "Fizz"
	 */
	private static String copyStringSegment (String sentence, int lowerBound, int upperBound) {
		String output = "";

		for (int i = lowerBound; i < upperBound; i++) {
			output = output + sentence.charAt(i);
		}
		return output;
	}
	
	/**
	 * Splits a String into an array using a specified character as a break point
	 * @param sentence The string to split
	 * @param splitChar The specific char to split on
	 * @return An array of the split values e.g. inputs ("Fizz-Buzz-FizzBuzz",'-') returns {"Fizz", "Buzz", "FizzBuzz"} 
	 */
	public static String[] splitString(String sentence, char splitChar){
		int returnCount, lowerBound = 0, upperBound = 0;
		String[] output;
		
		returnCount = containsCount(sentence, splitChar) + 1;
		
		output = new String[returnCount];
		
		if (returnCount == 1) {
			// Contains no char to split from, return whole string
			output[0] = sentence;
		}
		else {
			for (int i = 0; i < returnCount; i++) {
				for (int j = lowerBound; j < sentence.length(); j++) {
					if (sentence.charAt(j) == splitChar) {
						// j is split point
						upperBound = j;
						output[i] = copyStringSegment(sentence, lowerBound, upperBound); // returns lowerBound -> upperBound -1 eliminating splitChar
						lowerBound = j + 1;
						break;
					}
				}
			}
			output[returnCount - 1] = copyStringSegment(sentence, lowerBound, sentence.length());
		}
		return output;
	}
	
	/**
	 * Converts UTF-8 Latin supplement letters into English alphabetical equivalents
	 * @param raw The raw char containing potentially non-English letters
	 * @return An anglosized version of the input char for alphabetizing e.g. input('??') returns 'u'
	 */
	public static String anglosizeChar(char raw) {
		String anglosized;
		switch (raw) {
		case ('\''):
			anglosized = "";
			break;
				
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "A";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "a";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "E";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "e";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "I";
			break;
			
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "i";
			break;
					
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "O";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "o";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "U";
			break;
		
		case ('??'):
		case ('??'):
		case ('??'):
		case ('??'):
			anglosized = "u";
			break;
		
		case ('??'):
			anglosized = "ae";
			break;
		
		case ('??'):
			anglosized = "AE";
			break;
		
		case ('??'):
			anglosized = "C";
			break;
		
		case ('??'):
			anglosized = "c";
			break;
			
		case ('??'):
			anglosized = "D";
			break;
		
		case ('??'):
			anglosized = "d";
			break;
		
		case ('??'):
			anglosized = "m";
			break;
		
		case ('??'):
			anglosized = "N";
			break;
		
		case ('??'):
			anglosized = "n";
			break;
		
		case ('??'):
			anglosized = "ss";
			break;
		
		case ('??'):
			anglosized = "Th";
			break;
		
		case ('??'):
			anglosized = "th";
			break;
		
		case ('??'):
			anglosized = "Y";
			break;
		
		case ('??'):
		case ('??'):
			anglosized = "y";
			break;
		
		default:
			anglosized = "" + raw;
		}
		
		return anglosized;
	}
	
	/**
	 * Converts String containing UTF-8 Latin supplement letters into English word equivalents
	 * @param raw The raw string containing non-English letters
	 * @return A string comprised of best fit chars to simplify alphabetizing e.g. input("M??nchen") returns "Munchen"
	 */
	public static String anglosizeString(String raw) {
		String anglosized = "";
		
		for(int i = 0; i < raw.length(); i++) {
			anglosized = anglosized + anglosizeChar(raw.charAt(i));
		}
		return anglosized;
	}

	/**
	 * Compares two strings to see if they are identical
	 * @param base The active string
	 * @param comparison The string to compare too
	 * @return True if both strings are identical, false if not e.g. inputs ("Fizz","Fizz") returns true, inputs ("Fizz","Buzz") returns false
	 */
	public static boolean stringEquals(String base, String comparison) {
		boolean output = false;
		
		if (base.length() == comparison.length()) {
			output = true;
			for (int i = 0; i < base.length(); i++) {
				if (base.charAt(i) != comparison.charAt(i)) {
					output = false;
					break;
				}
			}
		}
		return output;
	}
	
	/**
	 * Removes sequences of a designated character from a string
	 * @param sentence The active string containing concatenated duplicates
	 * @param keyChar The char that should be reduced to 1 in a sequence
	 * @return String with extra chars removed e.g. input ("Fizz--Buzz", '-') returns "Fizz-Buzz"
	 */
	public static String removeDuplicateChars(String sentence, char keyChar) {
		String output = "";
		for (int i = 0; i < sentence.length() - 1; i++) {
			if (sentence.charAt(i) == keyChar && sentence.charAt(i + 1) == keyChar) {
				output = output + "";
			}
			else {
				output = output + sentence.charAt(i);
			}
		}
		output = output + sentence.charAt(sentence.length() - 1);
		return output;
	}
}
