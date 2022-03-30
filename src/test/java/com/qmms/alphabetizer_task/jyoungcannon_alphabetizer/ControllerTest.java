package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ControllerTest {

	Controller CTest = new Controller();
	
	@Test
	public void validateWordTest() {
		assertTrue(CTest.validateWord("Fizz-Buzz"));
		assertTrue(CTest.validateWord("Fizz'uzz"));
		assertTrue(CTest.validateWord("'izz'uzzs'"));
		assertFalse(CTest.validateWord("Fizz--Buzz"));
		assertFalse(CTest.validateWord("-Fizz-Buzz"));
		assertFalse(CTest.validateWord("Fizz-Buzz-"));
		assertFalse(CTest.validateWord("Fizz''uzz"));
		assertFalse(CTest.validateWord("FizzBuzz!"));
	}
	
	@Test
	public void regexValidateWordTest() {
		assertTrue(CTest.validateWordRegex("Fizz-Buzz"));
		assertTrue(CTest.validateWordRegex("Fizz'uzz"));
		assertTrue(CTest.validateWordRegex("'izz'uzzs'"));
		assertFalse(CTest.validateWordRegex("Fizz--Buzz"));
		assertFalse(CTest.validateWordRegex("-Fizz-Buzz"));
		assertFalse(CTest.validateWordRegex("Fizz-Buzz-"));
		assertFalse(CTest.validateWordRegex("Fizz''''uzz"));
		assertFalse(CTest.validateWordRegex("FizzBuzz!"));
	}
}
