package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FileIOTest {
	
	FileIO FIOTest = new FileIO();

	@Test
	public void FileIOInstanceTest() {
		FileIO FIOTest = new FileIO();
		assertEquals(FIOTest.getClass(), FileIO.class);
	}
	
	@Test
	public void FileIOConstructorTest() {
		// Default constructor
		assertEquals("UTF-8", FIOTest.getEncoder());
		
		// encoder parameter constructor
		FIOTest = new FileIO("UTF-16");
		assertEquals("UTF-16", FIOTest.getEncoder());
	}
	
	@Test
	public void getEncoderTest() {
		assertEquals("UTF-8", FIOTest.getEncoder());
	}
	
	@Test
	public void setEncoderTest() {
		FIOTest.setEncoder("UTF-16");
		assertEquals("UTF-16", FIOTest.getEncoder());
	}
	
	@Test
	public void loadDataTest() {
		ArrayList<String> result = new ArrayList<String>();
				
		// Single line input
		result = FIOTest.loadData("text_files/input/TestInput_SingleLine.txt");
		assertEquals("TestInput1.txt file has been opened successfully.", result.get(0));
		
		// Multiple line input
		result = FIOTest.loadData("text_files/input/TestInput_MultipleLines.txt");
		assertEquals("The 1st line has been read successfully.", result.get(0));
		assertEquals("The 2nd line has been read successfully.", result.get(1));
		
		// Wrong file location
		result = FIOTest.loadData("does_not_exist.txt");
		assertEquals(0, result.size());
	}
	
	@Test
	public void writeDataTest() {
		String[] paragraph1 = {"P1 Line 1", "P1 Line 2", "P1 Line 3"};
		String[] paragraph2 = {"P2 Line 1", "P2 Line 2", "P2 Line 3"};
		
		// Create a new file
		assertTrue(FIOTest.writeData("text_files/output/create_new_file.txt", paragraph1, false));
		
		// Append to a file
		FIOTest.writeData("text_files/output/append_to_file.txt", paragraph1, false);
		assertTrue(FIOTest.writeData("text_files/output/append_to_file.txt", paragraph2, true));
		
		assertFalse(FIOTest.writeData("folder_does_not_exist/file_does_not_exist.txt", paragraph1, false));
	}
}
