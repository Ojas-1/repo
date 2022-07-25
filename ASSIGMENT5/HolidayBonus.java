
public class HolidayBonus {

	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {

		double bonus[] = new double[data.length];
		double min = Integer.MAX_VALUE;
		int minRowIndex = Integer.MAX_VALUE;
		double highest = Integer.MIN_VALUE;
		int highestRowIndex = Integer.MIN_VALUE;
		int row = 0;

		for (int col = 0; col < 6; col++) {
			highestRowIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			minRowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

			while (row < 6) {
				if (row == highestRowIndex) {
					bonus[highestRowIndex] += high;
				} else if (row == minRowIndex) {

					bonus[minRowIndex] += low;
				} else if (col > data[row].length - 1) {
					bonus[row] += 0;

				} else if (data[row][col] <= 0) {
					bonus[row] += 0;

				} else {
					bonus[row] += other;
				}

				row++;

			}
			row=0;

		}

		return bonus;

	}

	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double total = 0;
		double bonus[] = HolidayBonus.calculateHolidayBonus(data, high, low, other);

		for (int i = 0; i < bonus.length; i++) {
			total += bonus[i];
		}

		System.out.println(total);
		return total;
	}

}