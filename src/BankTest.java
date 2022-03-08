
public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount teejay =  new BankAccount();
		teejay.printBalance();
		
		BankAccount mike =  new BankAccount();
		mike.deposit(500, "checking");
		mike.deposit(50, "savings");
		mike.withdraw(65.75, "checking");
		
		teejay.deposit(120.82, "savings");
		
		System.out.println(BankAccount.numOfAcc());
		System.out.println(BankAccount.getAccountsTotal());
	}
}
