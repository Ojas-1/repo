/* 
 * A savings account is an account that grows money over time 
 */
public class SavingsAccount extends BankAccount {
	/* rate of savings */
	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;

	/* makes a savings account */
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		// assigns savings number to account
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	/* makes a savings account */
	public SavingsAccount(SavingsAccount old, double d) {
		super(old, d);

		savingsNumber = Character.getNumericValue(old.getAccountNumber().charAt(old.getAccountNumber().length() - 1))
				+ 1;
		// assigns savings number to account
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	// creates interest and new balance based on the A=P(1+r)^t
	public void postInterest() {
		double value = 0;
		value = Math.pow(1.0 + rate, 1.0 / 12);
		// new balance to add
		value = super.getBalance() * value;
		super.setBalance(value);

	}

	// returns the new account number
	public String getAccountNumber() {
		return accountNumber;

	}

}
