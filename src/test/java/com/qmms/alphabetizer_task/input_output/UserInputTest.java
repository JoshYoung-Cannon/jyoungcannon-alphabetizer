package com.qmms.alphabetizer_task.input_output;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserInputTest {
	
	@Test
	public void StringManipulatorInstanceTest() {
		UserInput UITest = new UserInput();
		assertEquals(UITest.getClass(), UserInput.class);
	}
}
