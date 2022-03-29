package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileIO {

	private String encoder;

	/**
	 * @return encoder value
	 */
	public String getEncoder() {
		return encoder;
	}

	/**
	 * @param encoder The new encoder value
	 */
	public void setEncoder(String encoder) {
		this.encoder = encoder;
	}
	
	/**
	 * Constructs a new FileIO object with user defined value for the encoder field
	 */
	public FileIO(String encoder) {
		super();
		this.setEncoder(encoder);
	}
	
	/**
	 * Constructs a new FileIO object with default value of "UTF-8" for the encoder field
	 */
	public FileIO() {
		super();
		this.setEncoder("UTF-8");
	}
	
	/**
	 * Refactored code from www.codejava.net
	 * @author Original: www.codejava.net
	 * @param fileLocation Directory location of desired file
	 * @return ArrayList of all the lines within the file
	 */
	public ArrayList<String> loadData(String fileLocation) {
		ArrayList<String> rawData = new ArrayList<String>();
		try {
			FileInputStream inputStream = new FileInputStream(fileLocation);
			InputStreamReader reader = new InputStreamReader(inputStream, encoder);
			
			int character;
			String line = "";
            while ((character = reader.read()) != -1) {
            	if ((char) character != '\n' && (char) character != '\r') {
            		line = line + (char) character;
            	}
            	else {
            		if (line.length() > 0) {
            			rawData.add(line);
            			line = "";
            		}
            	}
            }
            
            if (line.length() > 0) {
            	rawData.add(line);
            }
            
            reader.close();
		}
		catch (IOException e) {
        	e.printStackTrace();
    	}
		
		return rawData;
	}
	
	/**
	 * Refactored code from www.codejava.net
	 * @author Original: www.codejava.net
	 * @param fileLocation Directory location of desired file
	 * @param data A string array of all the lines to write to the text file
	 * @param appendToFile Boolean if the input data should create/overwrite a file (false) or append to it (true)
	 * @return true when the file is successfully written, false if an error occurs
	 */
	public boolean writeData(String fileLocation, String[] data, boolean appendToFile) {
		int linePointer = 1;
		boolean success = false;
		try {
			FileOutputStream outputStream = new FileOutputStream(fileLocation, appendToFile);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, encoder);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			
			if (data.length > 0) {
				// write the 1st line
				if (appendToFile) {
					bufferedWriter.newLine();
				}
				bufferedWriter.write(data[0]);
			
				// write the rest of the lines
				if (data.length > 1) {
					for (int i = linePointer; i < data.length; i++) {
						bufferedWriter.newLine();
						bufferedWriter.write(data[i]);
					}
				}
			}
			bufferedWriter.close();
			success = true;
		}
		catch (IOException e) {
            e.printStackTrace();
            return success;
        }
		return success;
	}
}
