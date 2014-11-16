package com.javahonk;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FileLastModifiedDate {

	public static void main(String[] args) {
		
		//Get last modified date
		File file = new File("C:\\JavaHonk\\File\\JavaHonk.txt");
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    System.out.println("File Modified Date :- " + simpleDateFormat.format(file.lastModified()));
	    
	    
	    //Print list of file in directory and its modified date
	    File dir = new File("C:\\JavaHonk\\File");
        File[] files = dir.listFiles();
        Arrays.sort(files, new Comparator<File>()
        {
            public int compare(File f1, File f2)
            {
                return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
            }
        });
        
        System.out.println();
        for(int i=0, length=Math.min(files.length, 10); i<length; i++) {
            System.out.println(files[i]);
        }

        System.out.println();
		for (File f : files) {
			System.out.println(f.getName() + " " + simpleDateFormat.format(new Date(f.lastModified())));		

		}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													
	}
}
