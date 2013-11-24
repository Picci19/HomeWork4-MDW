package servicesAndLogic;

public class BankAccount {

	private String number;
	private double balance;
	private BankAccount bankDB[];

	/**
	 * @return the bankDB
	 */
	public BankAccount[] getBankDB() {
		return bankDB;
	}

	public BankAccount() {
		bankDB = new BankAccount[10];
		//Two bank accounts added for testing that the web service works
		BankAccount b1 = new BankAccount("1234 - 5678", 2319);
		BankAccount b2 = new BankAccount("5678 - 1234", 2013.14);
		addBankAccount(b1);
		addBankAccount(b2);
	}

	public BankAccount(String number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void addBankAccount(BankAccount b) {
		for (int i = 0; i < bankDB.length; i++) {
			if (bankDB[i] == null)
				bankDB[i] = b;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
