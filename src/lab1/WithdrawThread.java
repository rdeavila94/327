package lab1;

public class WithdrawThread extends Thread {
	private BankAcct acct;
	private int turns;
	public WithdrawThread (BankAcct acct, int turns) {
	this.acct = acct;
	this.turns = turns;
	}
	public void run ( ) {
		for (int k=0; k<turns; k++) {
			acct.withdraw(5);
			System.out.println ("ID: " + acct.getID());
			System.out.println ("Balance: " + acct.getBalance());
		}
	}
}