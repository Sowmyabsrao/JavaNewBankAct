package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		List<Account> accounts = new LinkedList<Account>();
	
		//Read a CSV file then create new accounts based on that data

		String file = "C:\\java workspace\\JavaProjects\\NewBankAccounts.csv";
		
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for(String[] newAccountHolder : newAccountHolders) {
			String name = newAccountHolder[0];
			String sSN = newAccountHolder[1];
			String accountType = newAccountHolder[2];
			double initialDeposit = Double.parseDouble(newAccountHolder[3]);
			
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initialDeposit));
			}
			else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initialDeposit));
			}
			else {
				System.out.println("Error Reading Account Type");
			}
		}
		
		for (Account acc : accounts) {
			System.out.println("\n******************");
			acc.showInfo();
		}
	}

}
