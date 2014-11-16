package com.javahonk;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileUsingScanner {
	
	private final static String FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String args[]) throws IOException {
		Path path = Paths.get(FILE_NAME);
		try (Scanner scanner = new Scanner(path, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				writeOutputOnConsole(scanner.nextLine());
			}
		}	
	}
	
	private static void writeOutputOnConsole(Object value) {
		System.out.println(String.valueOf(value));
	}
	
}
