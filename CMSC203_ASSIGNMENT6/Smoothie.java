/**
 * This class stores the info for a smoothie in the shop 
 * @author Ojas
 *
 */
public class Smoothie extends Beverage {
	private boolean gains;
	private int fruits;

	public Smoothie(String name, TYPE type, SIZE size, int f, boolean g) {
		super(name, type, size);
		fruits = f;
		gains = g;
	}
	
	public Smoothie(String name, SIZE size, int f, boolean g) {
		super(name, TYPE.SMOOTHIE, size);
		fruits = f;
		gains = g;
	}

	@Override
	public String toString() {
		return super.toString() + " Protein Powder: " + gains + " Nuber of Fruits: " + fruits + " Price: "
				+ calcPrice();

	}

	@Override
	public boolean equals(Object x) {

		if (this == x) {
			return true;
		}

		if (!(x instanceof Beverage)) {
			return false;
		}

		Smoothie a = (Smoothie) x;
		return (super.equals(x) && a.gains == gains && a.fruits == fruits);

	}
    // gets the price for one smoothie 
	@Override
	public double calcPrice() {
		double total = 0;

		if (gains) {
			total += 1.5;
		}
		if (fruits != 0) {

			total += (fruits * .50);
		}

		if (getSize() == SIZE.SMALL) {
			return total + getBasePrice();
		} else if (getSize() == SIZE.MEDIUM) {
			return total + getBasePrice() + 1;
		} else if (getSize() == SIZE.LARGE) {
			return total + getBasePrice() + 2;
		}

		return 0;
	}

	public int getNumOfFruits() {
		return fruits;
	}

	public boolean getAddProtein() {
		return gains;
	}
}
