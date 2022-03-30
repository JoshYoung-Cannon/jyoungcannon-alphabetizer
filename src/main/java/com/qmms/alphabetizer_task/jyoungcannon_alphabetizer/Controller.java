package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

	/**
	 * @param exceptionChars String containing all valid non-letter symbols
	 */
	public Controller(String exceptionChars) {
		super();
		this.exceptionChars = exceptionChars;
	}
	
	/**
	 * Defaults exceptionChars to ' and -
	 */
	public Controller() {
		super();
		this.exceptionChars = "'-";
	}

	// 1 - Ask for file location - provide option to quit
	// 2 - Get file data - if data file invalid return to step 1
	// 3 - Ensure only 1 space between each word
	// 4 - Separate into words by space
	// 5 - Sort words into valid and invalid lists
	// TODO make sure to only count "letter-/'letter" as valid not "letter-/'-/'letter", "-letter" or "letter-"
	// 6 - Alphabetize valid words
	// 7 - Display results
	// 8 - Save results - if data file invalid ask user to provide alternative or quit
	// 9 - End script
	
	private String exceptionChars;
	
	public String getExceptionChars() {
		return exceptionChars;
	}

	public void setExceptionChars(String exceptionChars) {
		this.exceptionChars = exceptionChars;
	}

	/**
	 * @param word String sequence being tested
	 * @return Returns true when String only contains valid characters
	 */
	private boolean validateChars(String word) {
		char angloChar;
		// Ensure word only contains valid characters
		for (int i = 0; i < word.length(); i++) {
			// If current char is not an exception char
			if (StringManipulator.containsCount(exceptionChars, word.charAt(i)) == 0) {
				angloChar = StringManipulator.anglosizeChar(word.charAt(i)).charAt(0);
				angloChar = StringManipulator.toLowerCase(angloChar);
				// If current char not an accepted character
				if (!StringManipulator.isLowerCase(angloChar)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * @param word String sequence being tested
	 * @return Returns true if all exception characters are correctly formatted
	 */
	private boolean regexValidateFormat(String word) {
		Pattern pattern = Pattern.compile("'{2,}|^-|-{2,}|-$");
	    Matcher matcher = pattern.matcher(word);
	    return !matcher.find();
	}
	
	/**
	 * @param word String sequence being tested
	 * @return Returns true if all exception characters are correctly formatted
	 */
	private boolean validateFormat(String word) {
		char hyphen = '-', apostrophe = '\'';
		if (word.charAt(0) == hyphen || word.charAt(word.length() - 1) == hyphen) {
			return false;
		}
		else {
			for (int i = 0; i < word.length() - 1; i++) {
				if (word.charAt(i) == hyphen && word.charAt(i + 1) == hyphen) {
					return false;
				}
				else if(word.charAt(i) == apostrophe && word.charAt(i + 1) == apostrophe) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * @param word String sequence being tested
	 * @return Returns true if word is both correctly formatted and only contains valid characters
	 */
	public boolean validateWord(String word) {
		if (validateChars(word) && validateFormat(word)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param word String sequence being tested
	 * @return Returns true if word is both correctly formatted and only contains valid characters
	 */
	public boolean validateWordRegex(String word) {
		if (validateChars(word) && regexValidateFormat(word)) {
			return true;
		}
		else {
			return false;
		}
	}
}
