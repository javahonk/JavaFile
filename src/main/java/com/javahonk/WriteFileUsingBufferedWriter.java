package com.javahonk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WriteFileUsingBufferedWriter {
	
	private final static String WRITE_TO_FILE_NAME = "C:\\JavaHonk\\File\\WriteToFile.txt";
	private final static String READ_TO_FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";

	public static void main(String args[]) throws IOException {

		File writeToFile = new File(WRITE_TO_FILE_NAME);
		File readFromFile = new File(READ_TO_FILE_NAME);
		String inputFileStringRepresentation = FileUtils.readFileToString(readFromFile, "UTF-8");
		
		if (!writeToFile.exists()) {
			writeToFile.createNewFile();
		}
	
		FileWriter fw = new FileWriter(writeToFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(inputFileStringRepresentation);
		bw.close();	
		
	}
	

}
