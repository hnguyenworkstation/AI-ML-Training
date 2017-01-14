import java.io.*;
import java.util.Arrays;

/********************************************
Template:
	+ To run: 
		- javac main.java
		- java Main
	+ Assuming this is a small dataset file < 100Mb;
	+ Using dataset.txt to add more data to test this algorithms
	with form of : "String" - "true or false" - w/o parantacies
	(For example: testing unique character in a string, you must add
	Corgies - true or Husky - true, or Elephant - false)
	+ Console output will tell your result.
********************************************/

class Main {
	private static FileInputStream fistream;
	private static BufferedReader br;
	private static final String filename = "dataset.txt";

	public static void main(String[] args) {
		try {
			// Creating input stream -- reading data from file
			fistream = new FileInputStream(filename);
			br = new BufferedReader(new InputStreamReader(fistream));

			String currentline;
			while ((currentline = br.readLine()) != null) {
				// splitted the string by space using regression
				String[] splittedStr = currentline.split("\\s+");

				if (isUnique(splittedStr[0])) {
					if (splittedStr[1].toLowerCase().equals("true")) {
						System.out.println(splittedStr[0] + ": " + splittedStr[1]
							+ " -- Correct!");
					} else {
						System.out.println(splittedStr[0] + ": " + splittedStr[1]
							+ " -- Wrong!!");
					}
				} else {
					if (splittedStr[1].toLowerCase().equals("false")) {
						System.out.println(splittedStr[0] + ": " + splittedStr[1]
							+ " -- Correct!");
					} else {
						System.out.println(splittedStr[0] + ": " + splittedStr[1]
							+ " -- Wrong!!");
					}
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	private static boolean isUnique(String line) {
		int[] ascii = new int[128];
		Arrays.fill(ascii, 0);

		for (int i = 0; i < line.length(); i++) {
			ascii[line.charAt(i)]++;
		}

		for (int i = 0; i < 128; i++) {
			if (ascii[i] > 1)
				return false;
		}

		return true;
	}
}