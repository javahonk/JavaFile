package com.javahonk;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileUsingReadAllByteData {

	private final static String WRITE_TO_FILE_NAME = "C:\\JavaHonk\\File\\WriteToFile.txt";
	private final static String READ_TO_FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";

	public static void main(String args[]) throws IOException {

		File writeToFile = new File(WRITE_TO_FILE_NAME);
		Path writeFilePath = Paths.get(WRITE_TO_FILE_NAME);
		Path readFilePath = Paths.get(READ_TO_FILE_NAME);

		if (!writeToFile.exists()) {
			writeToFile.createNewFile();
		}

		byte[] buf = Files.readAllBytes(readFilePath);
		Files.write(writeFilePath, buf);

	}

}
