package com.qmms.alphabetizer_task.string_interaction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

	Validator VTest = new Validator();
	
	@Test
	public void validateWordTest() {
		assertTrue(VTest.validateWord("Fizz-Buzz"));
		assertTrue(VTest.validateWord("Fizz'uzz"));
		assertTrue(VTest.validateWord("Fizz'uzzs'"));
		assertFalse(VTest.validateWord("'izz'uzzs'"));
		assertFalse(VTest.validateWord("Fizz--Buzz"));
		assertFalse(VTest.validateWord("-Fizz-Buzz"));
		assertFalse(VTest.validateWord("Fizz-Buzz-"));
		assertFalse(VTest.validateWord("Fizz''uzz"));
		assertFalse(VTest.validateWord("FizzBuzz!"));
	}
	
	@Test
	public void regexValidateWordTest() {
		assertTrue(VTest.validateWordRegex("Fizz-Buzz"));
		assertTrue(VTest.validateWordRegex("Fizz'uzz"));
		assertTrue(VTest.validateWordRegex("Fizz'uzzs'"));
		assertFalse(VTest.validateWordRegex("'izz'uzzs'"));
		assertFalse(VTest.validateWordRegex("Fizz--Buzz"));
		assertFalse(VTest.validateWordRegex("-Fizz-Buzz"));
		assertFalse(VTest.validateWordRegex("Fizz-Buzz-"));
		assertFalse(VTest.validateWordRegex("Fizz''''uzz"));
		assertFalse(VTest.validateWordRegex("FizzBuzz!"));
	}
}
