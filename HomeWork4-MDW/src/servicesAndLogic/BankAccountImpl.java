package servicesAndLogic;

import javax.jws.WebService;

@WebService
public class BankAccountImpl {

	// BankAccount for testing
	BankAccount b = new BankAccount(); // DB created now

	// validate existence of Bank account by account number
	public boolean validateExistence(String accountNumber) {
		for (int i = 0; i < b.getBankDB().length; i++) {
			if (b.getBankDB()[i] != null
					&& b.getBankDB()[i].getNumber().equals(accountNumber))
				return true;
		}
		return false;
	}

	// validate Account Balance by account number
	public boolean validateAccountBalance(String accountNumber) {
		for (int i = 0; i < b.getBankDB().length; i++) {
			if (b.getBankDB()[i] != null
					&& b.getBankDB()[i].getNumber().equals(accountNumber))
				if (b.getBankDB()[i] != null
						&& b.getBankDB()[i].getBalance() < 0)
					return false;
		}
		return true;
	}

	public void changeBalance(String accountNumber, char op, double amount) {
		// First, we have to find the BankAccount in the DB
		double balance = 0.0;
		for (int i = 0; i < b.getBankDB().length; i++) {
			if (b.getBankDB()[i].getNumber().equals(accountNumber)) {
				balance = b.getBankDB()[i].getBalance();
				if (op == '+') {
					balance += amount;
					b.getBankDB()[i].setBalance(balance);
				} else if (op == '-') {
					balance -= amount;
					b.getBankDB()[i].setBalance(balance);
				}
			}
		} // end for
	}
}
