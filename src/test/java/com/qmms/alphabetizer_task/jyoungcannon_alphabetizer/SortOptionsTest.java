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
	public void SortOptionsInstanceTest() {
		SortOptions SOTest = new SortOptions();
		assertEquals(SOTest.getClass(), SortOptions.class);
	}
	
	@Test
	public void bubbleSortAlphabetically() {
		String[] goal = new String[]{"Buzz", "Fizz", "FizzBuzz"};
		String[] input = new String[]{"Fizz", "Buzz", "FizzBuzz"};
		String[] result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[] {"FIZZ", "Fizz-Buzz-Fizz"};
		input = new String[]{"Fizz-Buzz-Fizz", "FIZZ"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[] {"FIZZ", "Fizz", "Fizz-Buzz", "Fizz-Buzz-Fizz", "FizzBuzz", "Fizz'Buzz", "fizz"};
		input = new String[]{"Fizz-Buzz-Fizz", "Fizz'Buzz", "fizz", "Fizz", "Fizz-Buzz", "FIZZ", "FizzBuzz"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
	}
	
	@Test
	public void stringCompareAlphabeticallyTest() {
		String[] goal = new String[]{};
		String[] input = new String[]{};
		String[] result;
		
		// Similar words
		goal = new String[]{"Aa","aa"};
		input = new String[]{"aa","Aa"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Identical words
		goal = new String[]{"Aa","Aa"};
		input = new String[]{"Aa","Aa"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aA","aA"};
		input = new String[]{"aA","aA"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aa","aa"};
		input = new String[]{"aa","aa"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AA","AA"};
		input = new String[]{"AA","AA"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Different words same size
		// Should swap
		goal = new String[]{"aB","ab"};
		input = new String[]{"ab","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","ab"};
		input = new String[]{"ab","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","ab"};
		input = new String[]{"ab","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","aB"};
		input = new String[]{"aB","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","aB"};
		input = new String[]{"aB","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","Ab"};
		input = new String[]{"Ab","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Should not swap	
		goal = new String[]{"aB","ab"};
		input = new String[]{"aB","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","ab"};
		input = new String[]{"Ab","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","ab"};
		input = new String[]{"AB","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","aB"};
		input = new String[]{"Ab","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","aB"};
		input = new String[]{"AB","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","Ab"};
		input = new String[]{"AB","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Different words different size
		// Should swap
		// x length < x + 1 length
		goal = new String[]{"aBc","ab"};
		input = new String[]{"ab","aBc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aBC","ab"};
		input = new String[]{"ab","aBC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Abc","ab"};
		input = new String[]{"ab","Abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AbC","ab"};
		input = new String[]{"ab","AbC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABc","ab"};
		input = new String[]{"ab","ABc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABC","ab"};
		input = new String[]{"ab","ABC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Abc","aB"};
		input = new String[]{"aB","Abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AbC","aB"};
		input = new String[]{"aB","AbC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABc","aB"};
		input = new String[]{"aB","ABc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABC","aB"};
		input = new String[]{"aB","ABC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABc","Ab"};
		input = new String[]{"Ab","ABc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABC","Ab"};
		input = new String[]{"Ab","ABC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// x length > x + 1 length
		goal = new String[]{"ab", "abc"};
		input = new String[]{"abc","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ab","abC"};
		input = new String[]{"abC","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","abc"};
		input = new String[]{"abc","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","abC"};
		input = new String[]{"abC","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","abc"};
		input = new String[]{"abc","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","abC"};
		input = new String[]{"abC","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","abc"};
		input = new String[]{"abc","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","abC"};
		input = new String[]{"abC","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","aBc"};
		input = new String[]{"aBc","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","aBC"};
		input = new String[]{"aBC","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","aBc"};
		input = new String[]{"aBc","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","aBC"};
		input = new String[]{"aBC","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","aBc"};
		input = new String[]{"aBc","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","aBC"};
		input = new String[]{"aBC","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","Abc"};
		input = new String[]{"Abc","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","AbC"};
		input = new String[]{"AbC","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","Abc"};
		input = new String[]{"Abc","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","AbC"};
		input = new String[]{"AbC","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","ABc"};
		input = new String[]{"ABc","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","ABC"};
		input = new String[]{"ABC","AB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Should not swap
		// x length < x + 1 length
		goal = new String[]{"ab","abc"};
		input = new String[]{"ab","abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ab","abC"};
		input = new String[]{"ab","abC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","abc"};
		input = new String[]{"aB","abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","abC"};
		input = new String[]{"aB","abC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","aBc"};
		input = new String[]{"aB","aBc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aB","aBC"};
		input = new String[]{"aB","aBC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","abc"};
		input = new String[]{"Ab","abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","abC"};
		input = new String[]{"Ab","abC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","aBc"};
		input = new String[]{"Ab","aBc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","aBC"};
		input = new String[]{"Ab","aBC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","Abc"};
		input = new String[]{"Ab","Abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Ab","AbC"};
		input = new String[]{"Ab","AbC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","abc"};
		input = new String[]{"AB","abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","abC"};
		input = new String[]{"AB","abC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","aBc"};
		input = new String[]{"AB","aBc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","aBC"};
		input = new String[]{"AB","aBC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","Abc"};
		input = new String[]{"AB","Abc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","AbC"};
		input = new String[]{"AB","AbC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","ABc"};
		input = new String[]{"AB","ABc"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AB","ABC"};
		input = new String[]{"AB","ABC"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// x length > x + 1 length
		goal = new String[]{"aBc","ab"};
		input = new String[]{"aBc","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"aBC","ab"};
		input = new String[]{"aBC","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Abc","ab"};
		input = new String[]{"Abc","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AbC","ab"};
		input = new String[]{"AbC","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"Abc","aB"};
		input = new String[]{"Abc","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"AbC","aB"};
		input = new String[]{"AbC","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABc","ab"};
		input = new String[]{"ABc","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABC","ab"};
		input = new String[]{"ABC","ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABc","aB"};
		input = new String[]{"ABc","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABC","aB"};
		input = new String[]{"ABC","aB"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABc","Ab"};
		input = new String[]{"ABc","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"ABC","Ab"};
		input = new String[]{"ABC","Ab"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
	}
	
	@Test
	public void charCompareAlphabeticallyTest() {
		String[] goal = new String[]{};
		String[] input = new String[]{};
		String[] result;
		
		// Similar letters
		goal = new String[]{"A","a"};
		input = new String[]{"a","A"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Identical letters
		goal = new String[]{"A","A"};
		input = new String[]{"A","A"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"a","a"};
		input = new String[]{"a","a"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Different letters
		// Should swap
		goal = new String[]{"a","b"};
		input = new String[]{"b","a"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"a","B"};
		input = new String[]{"B","a"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"A","b"};
		input = new String[]{"b","A"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"A","B"};
		input = new String[]{"B","A"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		// Should not swap
		goal = new String[]{"a","b"};
		input = new String[]{"a","b"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"A","b"};
		input = new String[]{"A","b"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"a","B"};
		input = new String[]{"a","B"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
		
		goal = new String[]{"A","B"};
		input = new String[]{"A","B"};
		result = SortOptions.bubbleSortAlphabetically(input);
		assertEquals(arrayToString(goal), arrayToString(result));
				
	}
}
