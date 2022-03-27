package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

public class StringManipulator {

	private static int containsCount(String sentence, char splitChar) {
		int splitCharCount = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if ((int) sentence.charAt(i) == (int) splitChar) {
				splitCharCount += 1;
			}
		}
		return splitCharCount;
	}
	
	private static String copyStringSegment (String sentence, int lowerBound, int upperBound) {
		String output = "";
		for (int i = lowerBound; i < upperBound; i++) {
			output = output + sentence.charAt(i);
		}
		return output;
	}
	
	public static String[] splitString(String sentence, char splitChar){
		int returnCount, lowerBound = 0, upperBound = 0;
		String[] output;
		
		returnCount = containsCount(sentence, splitChar) + 1;
		
		output = new String[returnCount];
		
		if (returnCount == 1) {
			output[0] = sentence;
		}
		else {
			for (int i = 0; i < returnCount; i++) {
				for (int j = lowerBound; j < sentence.length(); j++) {
					if (sentence.charAt(j) == splitChar) {
						// j is split point
						upperBound = j;
						output[i] = copyStringSegment(sentence, lowerBound, upperBound);
						lowerBound = j + 1;
					}
				}
			}
			output[returnCount - 1] = copyStringSegment(sentence, lowerBound, sentence.length());
		}
		return output;
	}
}
