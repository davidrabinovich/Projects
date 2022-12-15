package bsthw;

import java.io.*;
import java.util.*;

public class Main {
	customer[] AcctDB = new customer[10000];
	public void displaymenu(bst bank) throws FileNotFoundException {
	
		System.out.println("options menu: \n\n" + " press 1 to make a deposit: \n " + "press 2 to make a withdrawal: \n"
				+ " press 3 to check balance: \n" + "press 4 to open a new account:\n" + "press 5 to close an account:\n"
				+ "press 6 to exit the program:");
		Scanner sc = new Scanner(System.in);
		int choice = (sc.nextInt());
		if (choice == 1)
			deposit(bank);
		else if (choice == 2)
			withdraw(bank);
		else if (choice == 3)
			checkbalance(bank);
		else if (choice == 4)
			openaccount(bank);
		else if (choice == 5)
			closeaccount(bank);
		else if (choice == 6)
			exit(bank);
		sc.close();
	}

	private void closeaccount(bst bank) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("do you have your account number? please answer 1 for yes, 2 for no");
		int bool = sc.nextInt();
		if (bool==1) {
			System.out.print("please enter account number");
			Integer acctnum = sc.nextInt();
			customer customer = AcctDB[acctnum];
Integer acct = Integer.parseInt(customer.getacctNo());

			if(acct==acctnum) 
			
			{
				customer=new customer();
				System.out.print("account has been deleted. ");
				displaymenu(bank);
				sc.close();
				return;
			}
			else {
				System.out.print("account number not recognized. ");
				displaymenu(bank);
				sc.close();
				return;
			}
			
		}
		else {
		System.out.println("enter last name: ");
		String last = new String(sc.nextLine());
		System.out.println("enter first name: ");
		String first = new String(sc.nextLine());
		customer check = new customer(last, first, null, 0);
		if (bank.search(check) == null) {

			displaymenu(bank);
			sc.close();
			return;
		}
		customer customerdelete = (bank.search(check));
		bank.delete(customerdelete);
		System.out.println("customer " + last + ", " + first + " has been deleted from the system.");
		displaymenu(bank);
		sc.close();
		}
	}

	public void deposit(bst bank) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("do you have your account number? please answer 1 for yes, 2 for no");
		int bool = sc.nextInt();
		if (bool==1) {
			System.out.print("please enter account number");
			Integer acctnum = sc.nextInt();
			customer customer = AcctDB[acctnum];
Integer acct = Integer.parseInt(customer.getacctNo());

			if(acct==acctnum) 
			
			{
				System.out.println("enter amount to deposit: ");
				double deposit = (sc.nextDouble());
				customer.deposit(deposit);
				displaymenu(bank);
				sc.close();
				return;
			}
			else {
				System.out.print("account number not recognized. ");
				displaymenu(bank);
				sc.close();
				return;
			}
			
		}
		else {

		System.out.println("enter last name: ");
		String last = new String(sc.nextLine());
		System.out.println("enter first name: ");
		String first = new String(sc.nextLine());
		customer check = new customer(last, first, null, 0);
		if (bank.search(check) == null) {

			displaymenu(bank);
			sc.close();
			return;
		}
		customer customerdeposit = (bank.search(check));
		System.out.println("enter amount to deposit: ");
		double deposit = (sc.nextDouble());
		customerdeposit.deposit(deposit);
		displaymenu(bank);

		sc.close();

		displaymenu(bank);
		}
	}

	public void withdraw(bst bank) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("do you have your account number? please answer 1 for yes, 2 for no");
		int bool = sc.nextInt();
		if (bool==1) {
			System.out.print("please enter account number");
			Integer acctnum = sc.nextInt();
			customer customer = AcctDB[acctnum];
Integer acct = Integer.parseInt(customer.getacctNo());

			if(acct==acctnum) 
			
			{
				System.out.println("enter amount to withraw: ");
				double withdraw = (sc.nextDouble());
				customer.withdraw(withdraw);
				displaymenu(bank);
				sc.close();
				return;
			}
			else {
				System.out.print("account number not recognized. ");
				displaymenu(bank);
				sc.close();
				return;
			}
			
		}
		else {


		System.out.println("enter last name: ");
		String last = new String(sc.nextLine());
		System.out.println("enter first name: ");
		String first = new String(sc.nextLine());
		customer check = new customer(last, first, null, 0);
		if (bank.search(check) == null) {

			displaymenu(bank);
			sc.close();
			return;
		}
		customer customerwithdraw = (bank.search(check));

		System.out.println("enter amount to withraw: ");
		double withdraw = (sc.nextDouble());
		customerwithdraw.withdraw(withdraw);
		displaymenu(bank);
		sc.close();
		}
	}

	public void checkbalance(bst bank) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.print("do you have your account number? please answer 1 for yes, 2 for no");
		int bool = sc.nextInt();
		if (bool==1) {
			System.out.print("please enter account number");
			Integer acctnum = sc.nextInt();
			customer customer = AcctDB[acctnum];
Integer acct = Integer.parseInt(customer.getacctNo());

			if(acct==acctnum) 
			
			{
				double balance = customer.getbalance();
				System.out.println("balance is:  " + balance);
				displaymenu(bank);
				sc.close();
				return;
			}
			else {
				System.out.print("account number not recognized. ");
				displaymenu(bank);
				sc.close();
				return;
			}
			
		}
		else {

		System.out.println("enter last name: ");
		String last = new String(sc.nextLine());
		System.out.println("enter first name: ");
		String first = new String(sc.nextLine());
		customer check = new customer(last, first, null, 0);
		if (bank.search(check) == null) {

			displaymenu(bank);
			sc.close();
			return;
		}
		customer customerbalance = (bank.search(check));
		System.out.println("your balance is: " + customerbalance.getbalance() + "$");
		displaymenu(bank);
		sc.close();
	}
	}

	public void openaccount(bst bank) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter last name");
		String last = new String(sc.nextLine());
		System.out.println("enter first name");
		String first = new String(sc.nextLine());
		double r = Math.random();
		int rand = (int) (r * (9999 - 1000)) + 1000;
		customer newcustomer = new customer(last, first, Integer.toString(rand), 0);
		System.out.println("your account number is: " + newcustomer.getacctNo());
		System.out.println("how much would you like to deposit? ");
		double depositamt = (sc.nextDouble());
		newcustomer.deposit(depositamt);
		bank.insert(newcustomer);
AcctDB[rand] = newcustomer;
		displaymenu(bank);
		sc.close();
	}

	public void exit(bst bank) throws FileNotFoundException {
		customer[] end = bank.preordertraversal();
		PrintWriter out = new PrintWriter("output.txt");
		for (int i = 0; i < end.length; i++)
			out.println(end[i].getLast() + " " + end[i].getfirst() + " " + end[i].getacctNo() + " "
					+ end[i].getbalance() + " ");
		
		System.out.println("thank you, have a nice day!");
		out.close();
		return;
		
	}

	public bst loadcustomers() throws FileNotFoundException {
		bst bank = new bst();
		File inputfile = new File("customers.txt");
		Scanner sc = new Scanner(inputfile);
		while (sc.hasNext()) {
			String last = sc.next();
			String first = sc.next();
			String acctnumber = sc.next();
			int acctnum =Integer.parseInt(acctnumber);
			double balance = sc.nextDouble();
			customer newcustomer = new customer(last, first, acctnumber, balance);
			AcctDB [acctnum] = newcustomer;
			bank.insert(newcustomer);
			
		}
		sc.close();
		return bank;

	}

	public static void main(String args[]) throws FileNotFoundException {
		Main main = new Main();
		
		bst bank = new bst(main.loadcustomers());
		main.displaymenu(bank);

	}
}
