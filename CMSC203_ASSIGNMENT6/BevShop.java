import java.util.ArrayList;

/**
 * Ojas Malghan This class is the software behind the store's purchases and
 * keeps track of all the order info
 * 
 * @author Ojas
 *
 */
public class BevShop implements BevShopInteraface {
// number of alocholic drinks 
	public int numA;
	ArrayList<Order> orders = new ArrayList<>();
	final int AGE = 21;
	// current order
	Order curr;

	@Override
	public String toString() {
		String string = "";

		for (Order o : orders) {
			string += o.toString();
		}

		return string + " Total Monthly Sales: " + totalMonthlySale();
	}

	@Override
	public boolean validTime(int time) {
		if (time >= 8 && time <= 23) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getMaxNumOfFruits() {

		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return AGE;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > 5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return 3;
	}

	@Override
	public boolean eligibleForMore() {
		if (numA >= 3) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return numA;
	}

	@Override
	public boolean validAge(int age) {
		if (age >= 21) {
			return true;
		} else {
			return false;
		}
	}

	// reset all variables
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		numA = 0;
		curr = new Order(time, day, customerName, customerAge);
		orders.add(curr);

	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		curr.addNewBeverage(bevName, size, extraShot, extraSyrup);

	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		numA++;
		curr.addNewBeverage(bevName, size);

	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		curr.addNewBeverage(bevName, size, numOfFruits, addProtien);

	}

	@Override
	public int findOrder(int orderNo) {
		int index = -1;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				index = i;
				return index;
			}
		}
		return index;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double total = -1;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				total = orders.get(i).calcOrderTotal();
				return total;
			}
		}
		return total;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		for (Order o : orders) {

			total += o.calcOrderTotal();

		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		return curr;
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	// sort based on selection sort
	@Override
	public void sortOrders() {

		for (int i = 0; i < orders.size() - 1; i++) {

			int min_idx = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).compareTo(orders.get(min_idx)) == -1)
					min_idx = j;

				Order temp = orders.get(min_idx);

				orders.set(min_idx, orders.get(i));
				orders.set(i, temp);
			}
		}

	}
}
