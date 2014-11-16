package com.javahonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileUsingBufferedReader {
	
	private final static String FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String args[]) throws IOException {
		Path path = Paths.get(FILE_NAME);
		try (BufferedReader bufferedReader = Files.newBufferedReader(path, ENCODING)) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				writeOutputOnConsole(line);
			}
		}	
	}
	
	private static void writeOutputOnConsole(Object value) {
		System.out.println(String.valueOf(value));
	}
	
}
