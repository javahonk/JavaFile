package com.javahonk;

import java.io.File;

public class CreateFile {

	public static void main(String[] args) {

		try {

			File file = new File("C:\\JavaHonk\\File\\JavaHonk.txt");
			boolean fileCreated = file.createNewFile();
			if (fileCreated) {
				System.out.println("File created: "+file.getAbsolutePath());
			} else {
				System.out.println("File exists.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
