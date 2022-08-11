/** Ojas Malghan 
 * This class is an  class for making Coffee objects  
 * @author Ojas
 *
 */
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;

	public Coffee(String name, TYPE type, SIZE size, boolean extraShot, boolean extraS) {
		super(name, type, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraS;

	}
	

	 
	 
	 public Coffee(String name,SIZE size, boolean extraShot, boolean extraS) {
			super(name, TYPE.COFFEE, size);
			this.extraShot = extraShot;
			this.extraSyrup = extraS;

		}
	 

	@Override
	public String toString() {
		return super.toString() + " Extra Shot: " + extraShot + " Extra Syrup: " + extraSyrup + " Price: "
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

		Coffee a = (Coffee) x;
		return (super.equals(x) && a.extraSyrup == extraSyrup && a.extraShot == extraShot);

	}
    // gets price of coffee
	@Override
	public double calcPrice() {
		double total = 0;

		if (extraShot) {
			total += 0.5;
		}
		if (extraSyrup) {
			total += 0.5;
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

	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

}
