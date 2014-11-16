package com.javahonk;

import java.io.File;
import java.io.IOException;

public class DeleteFile {

	public static void main(String[] args) {

		try {
			File sourceFile = new File("C:\\JavaHonk\\File\\JavaHonk.txt");

			if (sourceFile.exists()) {

				boolean success = sourceFile.delete();
				if (success) {
					System.out.println("File deleted successfully.");
				}

			} else {

				sourceFile.createNewFile();
				boolean success = sourceFile.delete();
				if (success) {
					System.out.println("File deleted successfully.");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
