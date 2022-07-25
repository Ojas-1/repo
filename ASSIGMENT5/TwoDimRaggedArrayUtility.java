
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {

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

	public static double getHighestInArray(double[][] data) {
		double max = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (max < data[row][col]) {
					max = data[row][col];
				}
			}
		}

		return max;
	}

	public static double getHighestInColumn(double[][] data, int col) {
		double max = 0;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					if (max < data[row][col]) {
						max = data[row][col];
					}
				}

			}

		}

		return max;
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = 0;
		int index = 0;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					if (max < data[row][col]) {
						max = data[row][col];
						index = row;
					}
				}

			}

		}

		return index;
	}

	public static double getHighestInRow(double[][] data, int row) {
		double max = 0;

		for (int rows = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (rows == row) {
					if (max < data[rows][j]) {
						max = data[rows][j];
					}
				}

			}

		}

		return max;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = 0;
		int index = 0;

		for (int rows = 0; row < data.length; row++) {
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

	public static double getLowestInArray(double[][] data) {
		double min = Integer.MAX_VALUE;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (min > data[row][col]) {
					min = data[row][col];
				}
			}
		}

		return min;
	}

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
	
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = Integer.MAX_VALUE;
		int idx=0;

		for (int row = 0; row < data.length; row++) {
			for (int j = 0; j < data[row].length; j++) {
				if (j == col) {
					if (min > data[row][col]) {
						min = data[row][col];
						idx=row;
					}
				}

			}

		}

		return idx;
	}
	

	public static double getLowestInRow(double[][] data, int row) {
		double min = Integer.MAX_VALUE;

		for (int rows = 0; row < data.length; row++) {
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

	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = Integer.MAX_VALUE;
		int i = 0;

		for (int rows = 0; row < data.length; row++) {
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

	public static double getRowTotal(double[][] data, int row) {
		double total = 0;

		for (int col = 0; col < data[row].length; col++) {

			total += data[row][col];
		}

		return total;
	}

	public static double getTotal(double[][] data) {
		double total = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}

		return total;

	}

	public static double[][] readFile(File file) throws FileNotFoundException {
		double data[][];
		Scanner in = new Scanner(file);
		Scanner inRow = new Scanner(file);
		String line;
		String trimmed;
		String colLength[];
		int rows = 0;
		int curr = 0;

		while (in.hasNextLine()) {
			rows++;
			in.nextLine();
		}
		in.close();

		data = new double[rows][];

		while (inRow.hasNextLine()) {
			line = inRow.nextLine();
			trimmed = line.trim();
			colLength = trimmed.split(" ");

			data[curr] = new double[colLength.length];

			for (int col = 0; col < colLength.length; col++) {
				data[curr][col] = Double.parseDouble(colLength[col]);
			}
			curr++;
		}

		inRow.close();
		in.close();

		return data;
	}

	public static void writeToFile(double[][] data, File file) throws IOException {
		PrintWriter out = new PrintWriter(file);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				out.write(data[i][j] + " ");
			}
			out.write("\n");
		}

		out.close();
	}



}
