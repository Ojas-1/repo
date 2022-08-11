import java.util.ArrayList;

/**
 * This class stores a customers order 
 * @author Ojas
 */

/* refer to interface for notes on methods */ 

import java.util.Random;

public class Order implements OrderInterface, Comparable<Object> {
	private int orderNumber;
	private int orderTime;
	private DAY day;
	private Customer customer;
	ArrayList<Beverage> bev;

	
	// generate random order number 
	public int randomOrder() {
		Random r = new Random();
		int randomInt = r.nextInt(90000) + 10000;
		return randomInt;
	}

	public Order(int orderTime, DAY d, String customerName, int customerAge) {

		this.orderTime = orderTime;
		day = d;
		customer = new Customer(customerName, customerAge);
		orderNumber = randomOrder();
		bev = new ArrayList<>();
	}
	

	
	public Order(int orderTime, DAY d, Customer c) {

		this.orderTime = orderTime;
		day = d;
		customer = c;
		orderNumber = randomOrder();
		bev = new ArrayList<>();
	}
	
	
	
	// sort based on orderNumber 

	@Override
	public int compareTo(Object o) {
		Order order = (Order) o;

		if (order.orderNumber == orderNumber) {
			return 0;
		} else if (orderNumber > order.orderNumber) {
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public boolean isWeekend() {
		if (day == DAY.SATURDAY || day == DAY.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if (bev.size() == 0) {
			return null;
		}
		return bev.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee x = new Coffee(bevName, TYPE.COFFEE, size, extraShot, extraSyrup);
		bev.add(x);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol x = new Alcohol(bevName, TYPE.ALCOHOL, size, isWeekend());
		bev.add(x);

	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie x = new Smoothie(bevName, TYPE.SMOOTHIE, size, numOfFruits, addPRotien);
		bev.add(x);

	}

	@Override
	public double calcOrderTotal() {
		double total = 0;

		for (Beverage x : bev) {
			if (x.getType() == TYPE.ALCOHOL) {
				Alcohol a = (Alcohol) x;
				total += a.calcPrice();
			} else if (x.getType() == TYPE.COFFEE) {
				Coffee a = (Coffee) x;
				total += a.calcPrice();
			} else {
				Smoothie a = (Smoothie) x;
				total += a.calcPrice();
			}
		}

		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {

		int count = 0;

		for (Beverage x : bev) {
			if (x.getType() == type) {
				count++;
			}
		}

		return count;
	}

	public String toString() {
		String beverage = "";

		for (Beverage x : bev) {
			beverage += x.toString();
			beverage += "\n";

		}
		return "Order Number: " + orderNumber + " Time: " + orderTime + " Day: " + day + " " + customer.toString()
				+ " Total: "+calcOrderTotal()+"Beverages: " + beverage;
	}

	public Customer getCustomer() {
		Customer a = new Customer(customer);
		return a;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public int getOrderNo() {
		return orderNumber;
	}

	public DAY getOrderDay() {
		return day;
	}

	public int getTotalItems() {
		return findNumOfBeveType(TYPE.ALCOHOL) + findNumOfBeveType(TYPE.COFFEE) + findNumOfBeveType(TYPE.SMOOTHIE);
	}
	
	

}
