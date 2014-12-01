package edu.sjsu.cmpe282.mahout.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ConvertFiles{

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(
						"D:/Second Semester/CMPE282/ydata-ymusic-kddcup-2011-track1/trainIdx1.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"data/ratings.csv"));

		String line = br.readLine();


		String[] parts = line.split("\\|");
		String temp1 = parts[0];
		int temp2 = Integer.parseInt(parts[1]);
		String line1 = br.readLine();
		List<String> list = new ArrayList<String>();
		while (line1 != null) {
			for (int i = 1; i <= temp2; i++) {
				StringTokenizer tokenizer = new StringTokenizer(line1);
				while (tokenizer.hasMoreTokens()) {
					String temp = tokenizer.nextToken();
					list.add(temp);

				}
				bw.write(parts[0] + "," + list.get(0) + "," + list.get(1) + "\n");
				list.clear();
				line1 = br.readLine();
			}
		
		if(line1 != null)
		parts = line1.split("\\|");
	
		temp1 = parts[0];
		temp2 = Integer.parseInt(parts[1]);
		if(line1 != null)
		line1 = br.readLine();
		}
		br.close();
		bw.close();
		}
	}