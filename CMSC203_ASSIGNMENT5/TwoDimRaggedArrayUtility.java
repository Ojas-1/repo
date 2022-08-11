
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * This class manipulates a 2D array
 * @author Ojas
 *
 */
public class TwoDimRaggedArrayUtility {

	
	// get the average of the data set 
	public static double getAverage(double[][] data) {
		double total = 0;
		int size = 0;
		double average;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				size++;
				total += data[row][col];
			}
		}
		average = total / size;

		return average;

	}

	// get the total for a specfic column 
	public static double getColumnTotal(double[][] data, int col) {

		double total = 0;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					total += data[row][col];
				}
			}

		}

		return total;
	}

	// get the largest value in the array 
	public static double getHighestInArray(double[][] data) {
		double max = 0;
        
		// get the max value 
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (max < data[row][col]) {
					max = data[row][col];
				}
			}
		}
        
		// returns the max val 
		return max;
	}

	
	// get col high val
	public static double getHighestInColumn(double[][] data, int col) {
		double max = 0;
		
		
		// return the highest val in a col 
		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					// check max if it is really the max 
					if (max < data[row][col]) {
						max = data[row][col];
					}
				}

			}

		}

		return max;
	}

	//  get the index of the highest val
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = 0;
		int index = 0;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					//  check max
					if (max < data[row][col]) {
						max = data[row][col];
						// store index 
						index = row;
					}
				}

			}

		}

		return index;
	}

	
	// get the highest  value in the  row 
	public static double getHighestInRow(double[][] data, int row) {
		double max = 0;

		for (int rows = 0; rows < data.length; rows++) {
			for (int j = 0; j < data[row].length; j++) {
				// make  sure  the row we are looked for is being checked 
				if (rows == row) {
					if (max < data[rows][j]) {
						max = data[rows][j];
					}
				}

			}

		}

		return max;
	}

	// get the index of the highest row val
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = 0;
		int index = 0;
		
		// find the index of the highest val 
		for (int rows = 0; rows < data.length; rows++) {
			for (int j = 0; j < data[row].length; j++) {
				if (rows == row) {
					if (max < data[rows][j]) {
						max = data[rows][j];
						index = j;
					}
				}

			}

		}

		return index;

	}

	
	// same as before but the lowest in array 
	public static double getLowestInArray(double[][] data) {
		double min = Integer.MAX_VALUE;
		// check if it we are at the right min value
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (min > data[row][col]) {
					min = data[row][col];
				}
			}
		}

		// return the min value 
		return min;
	}

	
	// return the lowest in the column 
	public static double getLowestInColumn(double[][] data, int col) {
		double min = Integer.MAX_VALUE;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					if (min > data[row][col]) {
						min = data[row][col];
					}
				}

			}

		}

		return min;
	}
	// return the index of the  lowest in the column 
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = Integer.MAX_VALUE;
		int idx = 0;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					if (min > data[row][col]) {
						min = data[row][col];
						idx = row;
					}
				}

			}

		}

		return idx;
	}
	// return the lowest in the row 
	public static double getLowestInRow(double[][] data, int row) {
		double min = Integer.MAX_VALUE;

		for (int rows = 0; rows < data.length; rows++) {
			for (int j = 0; j < data[row].length; j++) {
				if (rows == row) {
					if (min > data[row][j]) {
						min = data[row][j];
					}
				}

			}

		}

		return min;
	}

	// return the index of the lowest in the row 
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = Integer.MAX_VALUE;
		int i = 0;

		for (int rows = 0; rows < data.length; rows++) {
			for (int j = 0; j < data[row].length; j++) {
				if (rows == row) {
					if (min > data[row][j]) {
						min = data[row][j];
						i = j;
					}
				}

			}

		}

		return i;
	}

	// get the total value of the row
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;

		for (int col = 0; col < data[row].length; col++) {

			total += data[row][col];
		}

		return total;
	}

	
	// get the total value of the array 
	public static double getTotal(double[][] data) {
		double total = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}

		return total;

	}

	// read in the file
	public static double[][] readFile(File file) throws FileNotFoundException {
		double data[][];
		Scanner in = new Scanner(file);
		Scanner inRow = new Scanner(file);
		String line;
		String trimmed;
		String colLength[];
		int rows = 0;
		int curr = 0;

		// make sure line exists 
		while (in.hasNextLine()) {
			rows++;
			in.nextLine();
		}
		in.close();

		// create a size of many rows as rows
		data = new double[rows][];

		// make sure there is a line to read 
		while (inRow.hasNextLine()) {
			// modify line and spilt it to get the data 
			line = inRow.nextLine();
			trimmed = line.trim();
			// deliminter is a space 
			colLength = trimmed.split(" ");
			// get the col length 
			data[curr] = new double[colLength.length];

			// make it a double and store 
			for (int col = 0; col < colLength.length; col++) {
				data[curr][col] = Double.parseDouble(colLength[col]);
			}
			curr++;
		}

		inRow.close();
		in.close();

		return data;
	}

	// write to file 
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
		// write to file using printwriter 
		PrintWriter out = new PrintWriter(file);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				out.write(data[i][j] + " ");
			}
			// add space 
			out.write("\n");
		}
        // close file  
		out.close();
	}

}
