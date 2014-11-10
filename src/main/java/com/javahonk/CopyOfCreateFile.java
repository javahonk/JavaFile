package com.javahonk;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class CopyOfCreateFile {

	public static void main(String[] args) {

		PrintWriter writer = null;
		Writer writer2 = null;
		FileOutputStream out = null;

		try {

			//Example 1: Create text file and write content in it
			writer = new PrintWriter("C:\\JavaHonk\\File\\JavaHonk.txt", "UTF-8");
			writer.println("Write something in first line");
			writer.println("Write something in second line");
			System.out.println("test");
			
			
			writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\JavaHonk\\File\\JavaHonk2.txt"), "utf-8"));
			writer2.write("Write something in first line\n");
			writer2.write("Write something in second line");
			
			String content = "Write something in file";
			byte data[] = content.getBytes();
			out = new FileOutputStream("C:\\JavaHonk\\File\\JavaHonk3.txt");
			out.write(data);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
				writer2.close();
				out.close();
			} catch (Exception ex) {
			}
		}

	}
}
