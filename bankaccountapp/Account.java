package bankaccountapp;

public abstract class Account implements IBaseRate {

// List commom properties for checking and saving accounts
	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	
// Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		
		//Set Account Number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract  void setRate();
	
	
	private String setAccountNumber() {
		String lastTwoofSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNum = (int)(Math.random() * Math.pow(10,3));
		return lastTwoofSSN + uniqueID + randomNum;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
// List common methods such as deposit, withdraw, transfer and showinfo
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount); 
		printBalance();
	}
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	public void printBalance() {
		System.out.println("Your Balance is now: $" + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"Name: " + name +
				"\nAccount Number: " + accountNumber +
				"\nBalance: $" + balance +
				"\nRate: " + rate +"%");
	}
	
	
	
	
	
}
