/** Ojas Malghan 
 * This class stores creates an alcohol drink 
 * @author Ojas
 *
 */
public class Alcohol extends Beverage {
	private boolean offer;

	// constructor for alcolhic beverages 
	public Alcohol(String name, TYPE type, SIZE size, boolean offer) {
		super(name, type, size);
		this.offer = offer;
	}
	public Alcohol(String name,SIZE size, boolean offer) {
		super(name, TYPE.ALCOHOL, size);
		this.offer = offer;
	}

   
	@Override
	public String toString() {
		return super.toString() + " Offer: " + offer + " Price: " + calcPrice();

	}

	@Override
	public boolean equals(Object x) {
// if exact object 
		if (this == x) {
			return true;
		}

		if (!(x instanceof Beverage)) {
			return false;
		}

		Alcohol a = (Alcohol) x;
		return (super.equals(x) && a.offer == offer);

	}
     
	
	// price for drink 
	@Override
	public double calcPrice() {
		double total = 0;

		if (offer) {
			total += .60;
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
	// getter 
	public boolean getOffer() {
		return offer;
	}

}
