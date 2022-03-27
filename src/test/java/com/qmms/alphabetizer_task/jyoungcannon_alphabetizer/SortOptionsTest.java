package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SortOptionsTest {
	
	private String arrayToString(String[] output) {
		String res = null;
		for(int i = 0; i < output.length; i++){
			if (i == 0) {
				res = output[i];
			}
			else {
				res = res + ", " + output[i];
			}
		}
		return res;
	}
	
	@Test
	public void bubbleSortAlphabetically() {
		String[] goal = new String[]{"Buzz", "Fizz", "FizzBuzz"};
		String[] input = new String[]{"Fizz", "Buzz", "FizzBuzz"};
		String[] result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
	}
}
