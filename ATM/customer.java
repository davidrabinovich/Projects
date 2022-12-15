package bsthw;

public class customer implements Comparable<customer> {

	private String last, first;
	private String acctNo;
	private double balance;

	public customer() {
		last = null;
		first = null;
		acctNo = null;
		balance = 0;
	}

	public customer(String last, String first, String acctNo, double balance) {
		this.last = last;
		this.first = first;
		this.acctNo = acctNo;
		this.balance = balance;
	}

	public customer(customer customer) {
		this.first = customer.first;
		this.last = customer.last;
		this.balance = customer.balance;
		this.acctNo = customer.acctNo;
	}

	public void setlast(String last) {
		this.last = last;
	}

	public String getLast() {
		return last;
	}

	public void setfirst(String first) {
		this.first = first;
	}

	public String getfirst() {
		return first;
	}

	public void setacctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getacctNo() {
		return acctNo;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	public double getbalance() {
		return balance;
	}

	public void deposit(double deposit) {
		if (deposit <= 0)
			System.out.println("error: deposit amount must be greater than 0");

		this.balance += deposit;
		System.out.println("new balance is: " + this.balance + "$");
	}

	public void withdraw(double withdraw) {
		if (withdraw <= 0)
			System.out.println("error: withdraw amount must be greater than 0");
		if (withdraw > this.balance) {
			System.out.println("error: withrawal amount exceeds current balance");
		return;	
		}
		this.balance -= withdraw;
		System.out.println("new balance is: " + this.balance + "$");
	}

	public boolean equals(customer other) {
		if (this.acctNo == other.acctNo)
			return true;
		else
			return false;
	}

	public String toString() {
		return (last + ", " + first + ", account number " + acctNo + ", balance is " + balance + "$");
	}

	public int compareTo(customer other) {
		int value = this.last.compareTo(other.last);
		if (value != 0)
			return value;

		value = this.first.compareTo(other.first);
		return value;
	}
}
