package com.javahonk;

import java.io.File;
import java.io.IOException;

public class SetFilePermission {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\JavaHonk\\File\\JavaHonk.txt");
		Boolean fileExists = file.exists();
		
		if (!fileExists) {
			file.createNewFile();
			fileExists = file.exists();
		}
		
		//Method to set the owner execute permission for this abstract pathname
		if (fileExists) {
			Boolean success = file.setExecutable(true);
            System.out.println("Owner execute permission for this abstract pathname: "+ success);
        }
		
		//Sets owner or everybody execute permission for this abstract pathname
		if (fileExists) {
			Boolean success = file.setExecutable(true, false);
            System.out.println("owner or everybody execute permission for this abstract pathname: "+ success);
        }
		
		//Method to set the owner write permission for this abstract pathname
        if (fileExists) {
        	Boolean success = file.setWritable(true);
            System.out.println("Set the owner write permission for this abstract pathname: "+ success);
        }

        //Sets owner or everybody write permission for this abstract pathname
        if (fileExists) {
        	Boolean success = file.setWritable(true,false);
            System.out.println("Owner or everybody write permission for this abstract pathname: "+ success);
        }
        
        //Marks file or directory named by this abstract pathname so that only read operations allowed
        if (fileExists) {
        	Boolean success = file.setReadOnly();
            System.out.println("Only read operation allowed: "+success);
        }
        
        //Sets the owner read permission for this abstract pathname
        if (fileExists) {
        	Boolean success = file.setReadable(true);
            System.out.println("Owner read permission for this abstract pathname: "+ success);
        }
       
        //Sets everybody's read permission for this abstract pathname
        if (fileExists) {
        	Boolean success = file.setReadable(true,false);
            System.out.println("Everybody's read permission for this abstract pathname: "+ success);
        }
		
	}

}
