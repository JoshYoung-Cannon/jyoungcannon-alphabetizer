package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ControllerTest {
	
	@Test
	public void StringManipulatorInstanceTest() {
		Controller CTest = new Controller();
		assertEquals(CTest.getClass(), Controller.class);
	}

}
