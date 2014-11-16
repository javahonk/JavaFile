package com.javahonk;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileUsingBufferedInputStream {
	
	private final static String FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	
	public static void main(String args[]) throws IOException {
		
		File file = new File(FILE_NAME);
		BufferedInputStream bin = null;

		// create FileInputStream object
		FileInputStream fin = new FileInputStream(file);

		// create object of BufferedInputStream
		bin = new BufferedInputStream(fin);

		// read file
		while (bin.available() > 0) {
			System.out.print((char) bin.read());
		}
		bin.close();
	}

}
