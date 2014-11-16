package com.javahonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileUsingStreamIO {
	
	private final static String FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	
	public static void main(String args[]) throws IOException {
		
		Path file = Paths.get(FILE_NAME);
		try (InputStream in = Files.newInputStream(file);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException ioException) {
		    System.err.println(ioException);
		}
	}

}
