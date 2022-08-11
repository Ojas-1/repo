
/**
 * This class makes the bonus for the stores 
 * @author Ojas
 *
 */
public class HolidayBonus {

	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
        // holds the bonus for the stores
		double bonus[] = new double[data.length];
		// used to find min row
		int minRowIndex = Integer.MAX_VALUE;
		// used to find highest row 
		int highestRowIndex = Integer.MIN_VALUE;
		// counter variable 
		int row = 0;
		
		// go through all the cols 
		for (int col = 0; col < 6; col++) {
			// store min and max 
			highestRowIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			minRowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
            
			// go through all the rows 
			while (row < 6) {
				// make sure it is a valid row 
				if (row < data.length) {
					// make sure it is a valid col length 
					if (col < data[row].length) {
                        // data under zero 
						if (data[row][col] <= 0) {
							
							bonus[row] += 0;
                         // add high val
						} else if (row == highestRowIndex) {
							bonus[highestRowIndex] += high;
						// add low val 
						} else if (row == minRowIndex) {
							bonus[minRowIndex] += low;
						// add nothing 
						} else if (col > data[row].length - 1) {
							bonus[row] += 0;
						// add other if not true 
						} else {
							bonus[row] += other;
						}

					}
				}
				row++;
			}

			row = 0;

		}

		return bonus;

	}

	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double total = 0;
		double bonus[] = HolidayBonus.calculateHolidayBonus(data, high, low, other);
// add the array up 
		for (int i = 0; i < bonus.length; i++) {
			total += bonus[i];
		}

// return total 
		return total;
	}



}