package com.javahonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileUsingBufferedStreamIO {
	
	private final static String FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	
	public static void main(String args[]) throws IOException {
		
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_NAME), charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException ioException) {
			System.err.format("IOException: ", ioException);
		}
	}

}
