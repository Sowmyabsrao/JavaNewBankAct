package bankaccountapp;

public interface IBaseRate {
	
	//Write a method that returns interest base rate
	default double getBaseRate() {
		return 2.5;
	}

}
