package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringManipulatorTest {

	@Test
    public void splitStringTest() {
		String[] goal = {"Fizz","Buzz"};
		String[] res = StringManipulator.splitString("Fizz-Buzz", '-');
        assertEquals(goal[0], res[0]);
        assertEquals(goal[1], res[1]);
        
        goal = new String[] {"Fizz"};
        res = StringManipulator.splitString("Fizz", '-');
        assertEquals(goal[0], res[0]);
    }
	
	@Test
	public void anglosizeString() {
		assertEquals("aeioussaecmthdny-YNDThCAEAEIOU", StringManipulator.anglosizeString("áéïôúßæçµþðñÿ'-ÝÑÐÞÇÆÂËÎÔÛ"));
	}
	
	@Test
	public void StringManipulatorInstanceTest() {
		StringManipulator SMTest = new StringManipulator();
		assertEquals(SMTest.getClass(), StringManipulator.class);
	}
	
	@Test
	public void stringEqualsTest() {
		assertTrue(StringManipulator.stringEquals("Fizz","Fizz"));
		assertFalse(StringManipulator.stringEquals("Fizz","Buzz"));
		assertFalse(StringManipulator.stringEquals("Fizz","Fizzz"));
	}
}
