
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	// STUDENT fill in dataSetSTUDENT with values, it must be a ragged array

	private double[][] dataSetStudent = { { 40, 20, 30 }, { 400, 50 }, { 10, 5, 20 } };

	private File inputFile, outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetStudent = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method Return the total of all the elements in the two
	 * dimensional array
	 */
	@Test
	public void testGetTotal() {

		assertEquals(575.0, TwoDimRaggedArrayUtility.getTotal(dataSetStudent), .001);

	}

	/**
	 * Student Test getAverage method Return the average of all the elements in the
	 * two dimensional array
	 */
	@Test
	public void testGetAverage() {

		assertEquals(71.875, TwoDimRaggedArrayUtility.getAverage(dataSetStudent), .001);

	}

	/**
	 * Student Test getRowTotal method Return the total of all the elements of the
	 * row. Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(90.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent, 0), .001);
		assertEquals(450.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent, 1), .001);
		assertEquals(35.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent, 2), .001);
	}

	/**
	 * Student Test getColumnTotal method Return the total of all the elements in
	 * the column. If a row in the two dimensional array doesn't have this column
	 * index, it is not an error, it doesn't participate in this method. Column 0
	 * refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {

		// private double[][] dataSetStudent = {{40,20,30},{400,50},{10,5,20}};

		assertEquals(450.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 0), .001);
		assertEquals(75.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 1), .001);
		assertEquals(50.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent, 2), .001);

	}

	/**
	 * Student Test getHighestInArray method Return the largest of all the elements
	 * in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(400.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSetStudent), .001);
	}

	/**
	 * Test the writeToFile method write the array to the outputFile File then read
	 * it back to make sure formatted correctly to read
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {

		// private double[][] dataSetStudent = {{40,20,30},{400,50},{10,5,20}};
		double[][] array = null;

		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetStudent, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);

		assertEquals(40, array[0][0], .001);
		assertEquals(20, array[0][1], .001);
		assertEquals(30, array[0][2], .001);

		assertEquals(400, array[1][0], .001);
		assertEquals(50, array[1][1], .001);

		assertEquals(10, array[2][0], .001);
		assertEquals(5, array[2][1], .001);
		assertEquals(20, array[2][2], .001);

	}

}
