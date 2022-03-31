package com.qmms.alphabetizer_task.string_interaction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	
	/**
	 * String containing all accepted non-letter characters
	 */
	private String exceptionChars;
	
	/**
	 * Constructs a new Validator with user defined value for the exceptionChars
	 * @param exceptionChars String containing all valid non-letter symbols
	 */
	public Validator(String exceptionChars) {
		super();
		this.exceptionChars = exceptionChars;
	}
	
	/**
	 * Constructs a new Validator with default exceptionChars ' and -
	 */
	public Validator() {
		super();
		this.exceptionChars = "'-";
	}
	
	/**
	 * exceptionChars getter
	 * @return Returns the exceptionChars
	 */
	public String getExceptionChars() {
		return exceptionChars;
	}

	/**
	 * exceptionChars setter
	 * @param exceptionChars String containing all accepted non-letter characters
	 */
	public void setExceptionChars(String exceptionChars) {
		this.exceptionChars = exceptionChars;
	}

	/**
	 * Checks all characters in a String are valid
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
	 * Checks a String is in a valid format using regex
	 * @param word String sequence being tested
	 * @return Returns true if all exception characters are correctly formatted
	 */
	private boolean regexValidateFormat(String word) {
		Pattern pattern = Pattern.compile("'{2,}|^'|^-|-{2,}|-$");
	    Matcher matcher = pattern.matcher(word);
	    return !matcher.find();
	}
	
	/**
	 * Checks a String is in a valid format
	 * @param word String sequence being tested
	 * @return Returns true if all exception characters are correctly formatted
	 */
	private boolean validateFormat(String word) {
		char hyphen = '-', apostrophe = '\'';
		if (word.charAt(0) == hyphen || word.charAt(word.length() - 1) == hyphen || word.charAt(0) == apostrophe) {
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
	 * Checks a given String is valid
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
	 * Checks a given String is valid using regex
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
