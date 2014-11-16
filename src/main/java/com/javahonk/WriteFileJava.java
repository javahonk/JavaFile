package com.javahonk;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class WriteFileJava {
	
	private final static String WRITE_TO_FILE_NAME = "C:\\JavaHonk\\File\\WriteToFile.txt";
	private final static String READ_TO_FILE_NAME = "C:\\JavaHonk\\File\\JavaHonk.txt";
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String args[]) throws IOException {

		File writeToFile = new File(WRITE_TO_FILE_NAME);
		File readFromFile = new File(READ_TO_FILE_NAME);
		Path writeFilePath = Paths.get(WRITE_TO_FILE_NAME);
		Path readFilePath = Paths.get(READ_TO_FILE_NAME);
		String inputFileStringRepresentation = FileUtils.readFileToString(readFromFile, "UTF-8");
		
		if (!writeToFile.exists()) {
			writeToFile.createNewFile();
		}
		
		//Reading All Bytes or Lines from File and Write all Bytes or Lines to File
		readAllByteWriteAllBytes(writeFilePath, readFilePath);
		
		//Write File by Using Buffered Stream I/O
		WriteUsingBufferedStreamIO(writeFilePath, inputFileStringRepresentation);
		
		
		//Write File by Using Stream I/O
		writeFileUsingStreamIO(writeFilePath, inputFileStringRepresentation);
		
		//Write to file using BufferedWriter
		writeFileUsingBufferedWriter(writeToFile, inputFileStringRepresentation); 
			 
		//Write to file using Files.write
		WriteFileUsingFileWrite(writeFilePath, readFilePath);
		
		
		//Write to very large file using BufferedWriter
		writeLargeFileUsingBufferedWriter(writeFilePath, readFilePath);	  
		
		
	}

	private static void writeLargeFileUsingBufferedWriter(Path writeFilePath, Path readFilePath)
			throws IOException {
		List<String> lines2 = Files.readAllLines(readFilePath, ENCODING);
		try (BufferedWriter writer = Files.newBufferedWriter(writeFilePath,ENCODING)) {
			for (String line : lines2) {
				writer.write(line);
				writer.newLine();
			}
		}
	}

	private static void WriteFileUsingFileWrite(Path writeFilePath,
			Path readFilePath) throws IOException {
		List<String> lines = Files.readAllLines(readFilePath, ENCODING);
		Files.write(writeFilePath, lines, ENCODING);
	}

	private static void writeFileUsingBufferedWriter(File writeToFile,
			String inputFileStringRepresentation) throws IOException {
		FileWriter fw = new FileWriter(writeToFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(inputFileStringRepresentation);
		bw.close();
	}

	private static void writeFileUsingStreamIO(Path writeFilePath, String inputFileStringRepresentation) {
		byte data[] = inputFileStringRepresentation.getBytes();
		try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(writeFilePath))) {
		    out.write(data, 0, data.length);
		} catch (IOException ioException) {
		    System.err.println(ioException);
		}
	}

	private static void WriteUsingBufferedStreamIO(Path writeFilePath, String inputFileStringRepresentation) {
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(writeFilePath, charset)) {
		    writer.write(inputFileStringRepresentation, 0, inputFileStringRepresentation.length());
		} catch (IOException ioException) {
		    System.err.format("IOException:", ioException);
		}
	}

	private static void readAllByteWriteAllBytes(Path writeFilePath,
			Path readFilePath) throws IOException {
		byte[] buf = Files.readAllBytes(readFilePath);
		Files.write(writeFilePath, buf);
	}

}
