package com.javahonk;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteFileUsingFileWrite {
	
	private final static String WRITE_TO_FILE_NAME = "C:\\JavaHonk\\File\\WriteToFile.txt";
	private final static String READ_TO_FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String args[]) throws IOException {

		File writeToFile = new File(WRITE_TO_FILE_NAME);
		Path writeFilePath = Paths.get(WRITE_TO_FILE_NAME);
		Path readFilePath = Paths.get(READ_TO_FILE_NAME);
		
		if (!writeToFile.exists()) {
			writeToFile.createNewFile();
		}
		
		List<String> lines = Files.readAllLines(readFilePath, ENCODING);
		Files.write(writeFilePath, lines, ENCODING);		
		
	}
	

}
