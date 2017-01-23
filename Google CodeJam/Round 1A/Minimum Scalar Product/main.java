/*
	@Author: Hung Nguyen
	@Date: 1/22/2016
	Workfile for Minimum Scalar Profuct problem.
*/

import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;

class Main {
	private static List<String> linesIn;
	private static List<String> linesOut;
	private static BufferedReader br;
	private static String fileout = "";
	private static PrintWriter pw;

	public static void main (String[] args) {
		if (args.length == 0) {
			System.out.println("Execute Steps: \n-- javac main.java"
				+ "\n-- java Main datafilename");
			System.exit(0);
		}

		collectInfor(args[0]);

		String splitChar = " ";


		// Do such algorithms here

		printOutputFile(args[0].substring(0, args[0].length() - 3) + ".out");
	}

	private static void collectInfor(String filename) {
		linesIn = new ArrayList<String>();
		String currentLine;

		try {
			br = new BufferedReader(new FileReader(filename));	
			while((currentLine = br.readLine()) != null) {	
				linesIn.add(currentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printOutputFile(String filename) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.close();
	}
}