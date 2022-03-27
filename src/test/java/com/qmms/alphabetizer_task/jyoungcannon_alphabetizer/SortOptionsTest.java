package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SortOptionsTest {
	
	@Test
	public void bubbleSortAlphabetically() {
		String[] goal = new String[]{"Buzz", "Fizz", "FizzBuzz"};
		String[] input = new String[]{"Fizz", "Buzz", "FizzBuzz"};
		String[] result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(goal[0], result[0]);
		assertEquals(goal[1], result[1]);
		assertEquals(goal[2], result[2]);
	}
}
