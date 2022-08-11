/** Ojas Malghan 
 * This class is an incomplete class for type of beverages 
 * @author Ojas
 *
 */
public abstract class Beverage {
	private String bevName;
	private TYPE type;
	private SIZE size;
	private final double BASE = 2.0;
	private final double PRICE_SIZE = 1.0;

	public Beverage(String name, TYPE type, SIZE size) {
		bevName = name;
		this.type = type;
		this.size = size;
	}

	public abstract double calcPrice();

	
	// shows string representation of a beverage 
	@Override
	public String toString() {
		return "Name: " + bevName + " Size: " + size;

	}

	@Override
	public boolean equals(Object x) {

		if (this == x) {
			return true;
		}

		if (!(x instanceof Beverage)) {
			return false;
		}

		Beverage a = (Beverage) x;
		return (a.bevName.equals(bevName) && type == a.type && a.size == size);

	}
	
	// getters 

	public String getBevName() {
		return bevName;
	}

	public TYPE getType() {
		return type;
	}

	public SIZE getSize() {
		return size;
	}

	public double getBasePrice() {
		return BASE;
	}

	public double getSizePrice() {
		return PRICE_SIZE;
	}

}
