package com.javahonk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class WriteUsingBufferedStreamIO {
	
	private final static String WRITE_TO_FILE_NAME = "C:\\JavaHonk\\File\\WriteToFile.txt";
	private final static String READ_TO_FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";	

	public static void main(String args[]) throws IOException {

		File writeToFile = new File(WRITE_TO_FILE_NAME);
		File readFromFile = new File(READ_TO_FILE_NAME);
		Path writeFilePath = Paths.get(WRITE_TO_FILE_NAME);
		String inputFileStringRepresentation = FileUtils.readFileToString(readFromFile, "UTF-8");
		
		if (!writeToFile.exists()) {
			writeToFile.createNewFile();
		}
		
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(writeFilePath,charset)) {
			writer.write(inputFileStringRepresentation, 0,inputFileStringRepresentation.length());
		} catch (IOException ioException) {
			System.err.format("IOException:", ioException);
		}		
		
	}	

}
