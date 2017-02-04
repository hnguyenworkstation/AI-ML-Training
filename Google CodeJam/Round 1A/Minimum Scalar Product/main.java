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
	private static int[] vector1 = new int[0];
	private static int[] vector2 = new int[0];

	public static void main (String[] args) {
		if (args.length == 0) {
			System.out.println("Execute Steps: \n-- javac main.java"
				+ "\n-- java Main datafilename");
			System.exit(0);
		}

		collectInfor(args[0]);

		String splitChar = " ";
		String outputFile = args[0].substring(0, args[0].length() - 3) + ".out";

		try {
			pw = new PrintWriter(new FileWriter(outputFile));

			// Do such algorithms here
			for (int i = 0; i < linesIn.size(); i++) {
				if (i == 0) {
					// this is the total data test cases
					// don't need to know this line with my current algorithm
					continue;
				}

				/*
					One simple test case
					3 
					1 3 -5
					-2 4 1
				*/
				if (i % 3 == 1) {
					// implementing array with data given
					vector1 = new int[Integer.parseInt(linesIn.get(i))];
					vector2 = new int[Integer.parseInt(linesIn.get(i))];
				} else if (i % 3 == 2) {
					String[] splitted = linesIn.get(i).split("\\s+");
					for (int j = 0; j < splitted.length; j++){
						vector1[j] = Integer.parseInt(splitted[j]);
					}
				} else if (i % 3 == 0) {
					String[] splitted = linesIn.get(i).split("\\s+");
					for (int j = 0; j < splitted.length; j++) {
						vector2[j] = Integer.parseInt(splitted[j]);
					}

					// get enough of needed information
					// now do the algorithms and get the result for the current case
					decSorting(vector2);
					incSorting(vector1);


					if (i == 3) {
						for (int k = 0; k < vector1.length; k++) {
							System.out.println(vector1[k]);
						}
					}
					int result = getMultiplication(vector1, vector2);
					pw.printf("Case #%d: %d\n", (int)(i/3), result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	private static void incSorting(int list[]) {
		int temp[] = new int[vector1.length];
		incMerge(temp, 0, list.length - 1);
	}

	private static void incMerge(int temp[], int first, int last) {
		if (first < last) {
			int middle = ((last - first) / 2) + first;
			incMerge(temp, first, middle);
			incMerge(temp, middle + 1, last);
			incMergeParts(temp, first, middle, last);
		}
	}

	private static void incMergeParts(int temp[], int first, int middle, int last) {
		for (int i = first; i < last; i++ ) {
			temp[i] = vector1[i]; 
		}

		int i = first;
		int j = middle + 1; 
		int k = first;

		while (i <= middle && j <= last) {
			if (temp[i] <= temp[j]) {
				vector1[k] = temp[i];
				i++;
			} else {
				vector1[k] = temp[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			vector1[k] = temp[i];
			i++;
			k++;
		}
	}

	private static void decSorting(int[] list) {
		decMerge(0, list.length - 1);
	}

	private static void decMerge(int first, int last) {
		if (first < last) {
			int middle = (int) Math.ceil((last - first) / 2) + first;
			decMerge(first, middle);
			decMerge(middle + 1, last);
			decMergeParts(first, middle, last);
		}
	}

	private static void decMergeParts(int first, int middle, int last) {
		int temp[] = new int[vector2.length];

		for (int i = first; i < last; i++ ) {
			temp[i] = vector2[i]; 
		}

		int i = first;
		int j = middle + 1; 
		int k = first;

		while (i <= middle && j <= last) {
			if (temp[i] >= temp[j]) {
				vector2[k] = temp[i];
				i++;
			} else {
				vector2[k] = temp[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			vector2[k] = temp[i];
			i++;
			k++;
		}
	}

	private static int getMultiplication(int[] vector1, int[] vector2) {
		int total = 0;
		for (int i = 0; i < vector1.length; i++) {
			total += (vector1[i] * vector2[i]);
		}
		return total;
	}
}