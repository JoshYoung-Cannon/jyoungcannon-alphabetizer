package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringManipulatorTest {

	@Test
	public void StringManipulatorInstanceTest() {
		StringManipulator SMTest = new StringManipulator();
		assertEquals(SMTest.getClass(), StringManipulator.class);
	}
	
	@Test
    public void splitStringTest() {
		String[] goal = {"Fizz","Buzz", "Fizz"};
		String[] res = StringManipulator.splitString("Fizz-Buzz-Fizz", '-');
        assertEquals(goal[0], res[0]);
        assertEquals(goal[1], res[1]);
        assertEquals(goal[2], res[2]);
        
        goal = new String[] {"Fizz","Buzz"};
        res = StringManipulator.splitString("Fizz-Buzz", '-');
        assertEquals(goal[0], res[0]);
        assertEquals(goal[1], res[1]);
        
        
        goal = new String[] {"Fizz"};
        res = StringManipulator.splitString("Fizz", '-');
        assertEquals(goal[0], res[0]);
    }
	
	@Test
	public void anglosizeString() {
		assertEquals("aeioussaecmthdny-YNDThCAEAEIOU", StringManipulator.anglosizeString("áéïôúßæçµþðñÿ'-ÝÑÐÞÇÆÂËÎÔÛ"));
		assertEquals("abc ABC", StringManipulator.anglosizeString("abc ABC"));
	}
	
	@Test
	public void stringEqualsTest() {
		assertTrue(StringManipulator.stringEquals("Fizz","Fizz"));
		assertFalse(StringManipulator.stringEquals("Fizz","Buzz"));
		assertFalse(StringManipulator.stringEquals("Fizz","Fizzz"));
		assertFalse(StringManipulator.stringEquals("Fizz",""));
	}
	
	@Test
	public void	isLowerCaseTest() {
		assertTrue(StringManipulator.isLowerCase('g'));
		assertFalse(StringManipulator.isLowerCase('G'));
		assertFalse(StringManipulator.isLowerCase('!'));
	}
	@Test
	public void isUpperCaseTest() {
		assertTrue(StringManipulator.isUpperCase('G'));
		assertFalse(StringManipulator.isUpperCase('g'));
		assertFalse(StringManipulator.isUpperCase('!'));
	}
	
	@Test
	public void toLowerCaseTest() {
		assertEquals('g',StringManipulator.toLowerCase('G'));
		assertEquals('g',StringManipulator.toLowerCase('g'));
		assertEquals('!',StringManipulator.toLowerCase('!'));
	}
	
	@Test
	public void toUpperCaseTest() {
		assertEquals('G',StringManipulator.toUpperCase('g'));
		assertEquals('G',StringManipulator.toUpperCase('G'));
		assertEquals('!',StringManipulator.toUpperCase('!'));
	}
	
	@Test
	public void removeDuplicateCharsTest() {
		assertEquals("Fizz-Buzz", StringManipulator.removeDuplicateChars("Fizz--Buzz", '-'));
		assertEquals("Fiz", StringManipulator.removeDuplicateChars("Fizz", 'z'));
		assertEquals("Fizz-Buzz-FizzBuzz", StringManipulator.removeDuplicateChars("Fizz--Buzz-FizzBuzz", '-'));
		assertEquals("<-Fizz->", StringManipulator.removeDuplicateChars("<----Fizz---->", '-'));
	}
}
