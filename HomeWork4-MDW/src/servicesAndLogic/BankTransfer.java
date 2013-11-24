package servicesAndLogic;

import javax.jws.WebService;

@WebService
public class BankTransfer {

	BankAccountImpl bankAccount = new BankAccountImpl();
														
	public boolean transfer(String from, String to, double amount) {
		// 'from', 'to' are account numbers
		// check existence of from and to account and check the balance of from
		// account
		if (bankAccount.validateExistence(from) == false
				|| bankAccount.validateExistence(to) == false
				|| bankAccount.validateAccountBalance(from) == false)
			return false;
		else {
			// if OK change balance of both accounts and return true
			bankAccount.changeBalance(from, '-', amount);
			bankAccount.changeBalance(to, '+', amount);
			return true;
		}
	}

}
