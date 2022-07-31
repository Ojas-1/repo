/*
 * Checkins Account is an extensiopn of BankAccount and provides some features
 * of a bank account plues some more
 */
public class CheckingAccount extends BankAccount {
	/* fee to add when withdraw */
	private double FEE;

	/* creates a checking account object */
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		super.setAccountNumber(getAccountNumber() + "-10");
		FEE = 0.15;

	}

	// overrides an the super class withdraw method
	@Override
	public boolean withdraw(double amount) {
		amount += FEE;
		return super.withdraw(amount);

	}

}
