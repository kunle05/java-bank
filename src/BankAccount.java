import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class BankAccount {
	private double checkingBalance;
	private double savingsBalance;
	private Long accountNo;
	private static double accountsTotal;
	private static int numAccounts;
	
	public BankAccount() {
		accountNo = this.generateAC();
		numAccounts++;
	}
	
	private Long generateAC() {
		Random rand = new Random();
		return rand.nextLong(999999999) + 999999999;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	private void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	private void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	private static void sumAccountsTotal(double deposit) {
		double total = accountsTotal + deposit;		
		BigDecimal bd =  new BigDecimal(total).setScale(2, RoundingMode.UP);
		accountsTotal = bd.doubleValue();
	}
	
	public static double getAccountsTotal() {
		return accountsTotal;
	}
	
	public void printBalance() {
		System.out.println("Account: " + accountNo);
		System.out.println("Checking balance: " + checkingBalance);
		System.out.println("Savings balance: " + savingsBalance);
		System.out.println("Account total: " + (checkingBalance + savingsBalance));
		System.out.println("-------------");
		System.out.println("");
	}
	
	public void deposit(double amount, String account) {
		if(account.equals("checking")) {
			this.setCheckingBalance(amount + checkingBalance);
		}
		if(account.equals("savings")) {
			this.setSavingsBalance(amount + savingsBalance);
		}
		sumAccountsTotal(amount);
		this.printBalance();
	}
	
	public void withdraw(double amount, String account) {
		if(account.equals("checking") && checkingBalance >= amount) {
			this.setCheckingBalance(checkingBalance - amount);
			sumAccountsTotal(-amount);
		}
		else if(account.equals("savings") && savingsBalance >= amount) {
			this.setSavingsBalance(savingsBalance - amount);
			sumAccountsTotal(-amount);
		}
		else {
			System.out.println(String.format("Insufficient balance in your %s account", account));
		}
		this.printBalance();
	}
	
	public static int numOfAcc() {
		return numAccounts;
	}
}
