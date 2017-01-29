package lab1;

import java.util.concurrent.locks.ReentrantLock;

public class BankAcct {
	private double balance;
	private String id;
	ReentrantLock lock = new ReentrantLock();

	public BankAcct(String id) {
		balance = 0;
		this.id = id;
	}

	public double getBalance() {
		lock.lock();
		try {
			return balance;
		}
		finally {
			lock.unlock();
		}
	}
	
	public void deposit(double amt) {
		lock.lock();
		try {
			if (amt >= 0)
				balance += amt;
		}
		finally {
			lock.unlock();
		}
	}

	public void withdraw(double amt) {
		lock.lock();
		try {
			if (amt <= balance) {
				balance -= amt;
			}
		}
		finally {
			lock.unlock();
		}
	}

	public String getID() {
		return id;
	}

		
		public static void main (String [] args) {
			BankAcct swag = new BankAcct("Richards");
			DepositThread d = new DepositThread(swag, 50);
			WithdrawThread w = new WithdrawThread(swag, 50);
			d.start();
			w.start();
		}
}
