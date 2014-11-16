package com.javahonk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

public class CopyFile {
	
	InputStream inputStream = null;
	OutputStream outputStream = null;
	FileChannel source = null;
    FileChannel destination = null;

	public static void main(String[] args) {
		
		CopyFile copyFile = new CopyFile();
		File sourceFile =new File("C:\\JavaHonk\\File\\JavaHonk.txt");
	    File destinationFile =new File("C:\\JavaHonk\\File\\JavaHonk_Copy.txt");
		
		copyFile.copyUsingCovertingStream(sourceFile, destinationFile);
		
		copyFile.copyFileUsingNIOChannel(sourceFile, destinationFile);
		
		copyFile.copyFileUsingApacheCommonsIO(sourceFile, destinationFile);
		
		copyUsingNewNIOFilesPackage(sourceFile, destinationFile);

	}


	private void copyUsingCovertingStream(File sourceFile, File destinationFile) {
		try {
	    	
			if (!destinationFile.exists()) {
				destinationFile.createNewFile();
			}
		    
		    inputStream = new FileInputStream(sourceFile);
		    outputStream = new FileOutputStream(destinationFile);

		    byte[] buffer = new byte[1024];
		    int length;
			while ((length = inputStream.read(buffer)) > 0){
				outputStream.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	private void copyFileUsingNIOChannel(File sourceFile,
			File destinationFile) {
		try {
			if (!destinationFile.exists()) {
				destinationFile.createNewFile();
			}

			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destinationFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (source != null) {
					source.close();
				}
				if (destination != null) {
					destination.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	private void copyFileUsingApacheCommonsIO(File sourceFile,
			File destinationFile) {
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copyUsingNewNIOFilesPackage(File sourceFile,
			File destinationFile) {
		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
