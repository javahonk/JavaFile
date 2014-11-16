package com.javahonk;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileUsingNIOFiles {
	
	private final static String FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String args[]) throws IOException {
		
		Path path = Paths.get(FILE_NAME);
		List<String> lines = Files.readAllLines(path, ENCODING);
		for (String string : lines) {
			System.out.println(string);
		}		
	}
	
}
