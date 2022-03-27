package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StringManipulatorTest {

	@Test
    public void splitStringTest() {
		ArrayList<String> goal = new ArrayList<>(List.of("Fizz","Buzz"));
		ArrayList<String> res = StringManipulator.splitString("Fizz-Buzz", '-');
        assertEquals(goal, res);
    }
}
