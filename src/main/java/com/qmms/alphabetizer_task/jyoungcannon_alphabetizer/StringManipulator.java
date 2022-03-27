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
						output[i] = copyStringSegment(sentence, lowerBound, upperBound); // returns lowerBound -> upperBound -1 eliminating splitChar
						lowerBound = j + 1;
					}
				}
			}
			output[returnCount - 1] = copyStringSegment(sentence, lowerBound, sentence.length());
		}
		return output;
	}
	
	private static String anglosizeChar(char raw) {
		String anglosized;
		switch (raw) {
		case ('\''):
			anglosized = "";
			break;
				
		case ('Ä'):
		case ('Å'):
		case ('Á'):
		case ('Â'):
		case ('À'):
		case ('Ã'):
			anglosized = "A";
			break;
		
		case ('â'):
		case ('ä'):
		case ('à'):
		case ('å'):
		case ('á'):
		case ('ã'):
			anglosized = "a";
			break;
		
		case ('É'):
		case ('Ê'):
		case ('Ë'):
		case ('È'):
			anglosized = "E";
			break;
		
		case ('é'):
		case ('ê'):
		case ('ë'):
		case ('è'):
			anglosized = "e";
			break;
		
		case ('Í'):
		case ('Î'):
		case ('Ï'):
		case ('Ì'):
			anglosized = "I";
			break;
			
		case ('ï'):
		case ('î'):
		case ('ì'):
		case ('í'):
		case ('ı'):
			anglosized = "i";
			break;
					
		case ('Ö'):
		case ('Ó'):
		case ('Ô'):
		case ('Ò'):
		case ('Õ'):
			anglosized = "O";
			break;
		
		case ('ô'):
		case ('ö'):
		case ('ò'):
		case ('ó'):
		case ('õ'):
			anglosized = "o";
			break;
		
		case ('Ü'):
		case ('Ú'):
		case ('Û'):
		case ('Ù'):
			anglosized = "U";
			break;
		
		case ('ü'):
		case ('û'):
		case ('ù'):
		case ('ú'):
			anglosized = "u";
			break;
		
		case ('æ'):
			anglosized = "ae";
			break;
		
		case ('Æ'):
			anglosized = "AE";
			break;
		
		case ('Ç'):
			anglosized = "C";
			break;
		
		case ('ç'):
			anglosized = "c";
			break;
			
		case ('Ð'):
			anglosized = "D";
			break;
		
		case ('ð'):
			anglosized = "d";
			break;
		
		case ('µ'):
			anglosized = "m";
			break;
		
		case ('Ñ'):
			anglosized = "N";
			break;
		
		case ('ñ'):
			anglosized = "n";
			break;
		
		case ('ß'):
			anglosized = "ss";
			break;
		
		case ('Þ'):
			anglosized = "Th";
			break;
		
		case ('þ'):
			anglosized = "th";
			break;
		
		case ('Ý'):
			anglosized = "Y";
			break;
		
		case ('ÿ'):
		case ('ý'):
			anglosized = "y";
			break;
		
		default:
			anglosized = "" + raw;
		}
		
		return anglosized;
	}
	
	public static String anglosizeString(String raw) {
		String anglosized = "";
		
		for(int i = 0; i < raw.length(); i++) {
			anglosized = anglosized + anglosizeChar(raw.charAt(i));			
		}
		return anglosized;
	}

	public static boolean stringEquals(String base, String comparison) {
		return false;
	}
}
