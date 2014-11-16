package com.javahonk;

import java.io.File;

public class RenameFile {

	public static void main(String[] args) {
		
		File oldFile = new File("C:\\JavaHonk\\File\\JavaHonk.txt");
		File newName = new File("C:\\JavaHonk\\File\\JavaHonk_Renamed.txt");
		
		if (newName.exists()) {
			System.out.println("File name already exists");
		} else {
			boolean success = oldFile.renameTo(newName);
			if (success) {
				System.out.println("File renamed successfully");
			}
		}		

	}

}
