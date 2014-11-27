package com.rest.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.util.Scanner;

import org.apache.taglibs.standard.extra.spath.Path;

public class Split {
	private static final String File_Path = "C:/euphonyDataSet/track1/trackData1.txt";
	public void splitFile(){
		try {
			
			double nol = 88000.0; // No. of lines to be split and saved in each
									// output file.
			File file = new File(File_Path);
			Scanner scanner = new Scanner(file);
			int count = 0;
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				count++;
			}
			//System.out.println("Lines in the file: " + count); 

			double temp = (count / nol);
			int temp1 = (int) temp;
			int nof = 0;
			if (temp1 == temp) {
				nof = temp1;
			} else {
				nof = temp1 + 1;
			}
			System.out.println("No. of files to be generated :" + nof); 

			// ---------------------------------------------------------------------------------------------------------

			// Actual splitting of file into smaller files

			FileInputStream fstream = new FileInputStream(File_Path);
			DataInputStream in = new DataInputStream(fstream);

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;

			for (int j = 1; j <= nof; j++) {
				FileWriter fwriter = new FileWriter("C:/euphonyDataSet/track1/track" + j + ".txt"); // Destination File Location
				BufferedWriter out = new BufferedWriter(fwriter);
				
				for (int i = 1; i <= nol; i++) {
					
					line = br.readLine();
									
					
					if (line != null) {
						out.write(line);
						if (i != nol) {
							out.newLine();
						}
					}
				}
				out.close();
			}

			in.close();
			

			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	public static void main(String args[]) {
		Split split = new Split();
		split.splitFile();

	}

}
