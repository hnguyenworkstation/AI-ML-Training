/********************************************
Template:
	+ To run: 
		- javac main.java
		- java Main
	+ Assuming this is a small dataset file < 100Mb;
	+ Using dataset.txt to add more data to test this algorithms
	with form of : "String1" "String2" "true or false" - w/o parantacies
	(For example: testing permutation of two strings, you must add
	orgro grroo true or husky  true)
	+ Console output will tell your result.
********************************************/

import java.io.*;
import java.util.Arrays;


class Main {
	private static FileInputStream fiStream;
	private static BufferedReader br;
	private static final String filename = "dataset.txt";

	public static void main(String[] args) {
		try{
			// Creating input stream -- reading data from file
			fiStream = new FileInputStream(filename);
			br = new BufferedReader(new InputStreamReader(fiStream));

			// Read and process every line of the data set
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				String[] splittedStr = currentLine.split("\\s+");

				if (arePermutation(splittedStr[0], splittedStr[1])) {
					if (splittedStr[2].toLowerCase().equals("true")) {
						System.out.println(splittedStr[0] + "- " + splittedStr[1]
							+ ": " + splittedStr[2] + " -- Correct!");
					} else {
						System.out.println(splittedStr[0] + "- " + splittedStr[1]
							+ ": " + splittedStr[2] + " -- Wrong!!");
					}
				} else {
					if (splittedStr[2].toLowerCase().equals("false")) {
						System.out.println(splittedStr[0] + "- " + splittedStr[1]
							+ ": " + splittedStr[2] + " -- Correct!");
					} else {
						System.out.println(splittedStr[0] + "- " + splittedStr[1]
							+ ": " + splittedStr[2] + " -- Wrong!!");
					}
					break;
				}
			}

			br.close();
		} catch (Exception e) {

		}
	}

	private static boolean arePermutation(String first, String second) {
		int[] ascii = new int[128];
		Arrays.fill(ascii, 0);

		for (int i = 0; i < first.length(); i++) {
			ascii[first.charAt(i)]++;
		}

		for (int i = 0; i < second.length(); i++) {
			ascii[second.charAt(i)]--;
		}

		for (int i = 0; i < 128; i++) {
			if (ascii[i] != 0) {
				return false;
			}
		}

		return true;
	}
}