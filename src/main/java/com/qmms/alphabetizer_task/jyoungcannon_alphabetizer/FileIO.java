package com.qmms.alphabetizer_task.jyoungcannon_alphabetizer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileIO {

	private String defaultEncoder;

	public String getDefaultEncoder() {
		return defaultEncoder;
	}

	private void setDefaultEncoder(String defaultEncoder) {
		this.defaultEncoder = defaultEncoder;
	}
	
	public FileIO(String defaultEncoder) {
		super();
		this.setDefaultEncoder(defaultEncoder);
	}
	
	public FileIO() {
		super();
		this.setDefaultEncoder("UTF-8");
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
			InputStreamReader reader = new InputStreamReader(inputStream, defaultEncoder);
			
			int character;
			String line = "";
			
            while ((character = reader.read()) != -1) {
            	if ((char) character == '\n') {
            		rawData.add(line);
            		line = "";
            	}
                line = line + (char) character;
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
}
