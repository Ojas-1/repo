
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestSTUDENT {

	private double[][] dataSet1 = { { 200, 223, 31234 }, { 412300, 5321 }, { 62100, 7123, 8132 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000
	 * as other
	 */

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 5000, 1000, 2000);
			assertEquals(7000.0, result[0], .001);
			assertEquals(7000.0, result[1], .001);
			assertEquals(8000.0, result[2], .001);

		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	/**
	 * Test calculateHolidayBonus method with a high of 100000, low of 2500 and
	 * 50000 as other
	 */

	@Test
	public void testCalculateHolidayBonusB() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1, 100000, 2500, 50000);

			assertEquals(105000.0, result[0], .001);
			assertEquals(150000.0, result[1], .001);
			assertEquals(152500.0, result[2], .001);

		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {

		assertEquals(150430.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 50000, 10, 200), .001);

	}

	/**
	 * Test calculateTotalHolidayBonus method with a high of 10000, low of 2500 and
	 * 4000 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {

		assertEquals(45500.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 10000, 2500, 4000), .001);

	}

}
