import java.util.Scanner;

public class ClassDemo {

	public static void main(String[] args) {
		
		Account ac=new Account();
		/*
		ac.deposit();
		ac.showBalance();
		ac.withdraw();
		ac.showBalance();
		*/
		ac.showBalance();
		
		Account ac1=new Account(20000);
		ac1.showBalance();
		
		Account ac2=new Account(ac1);
		ac2.showBalance();
	}

	
}

class Account
{
	private String name;
	private String acNumber;
	private int balance;
	
	public Account()
	{
		balance=10000;
		System.out.println("Default Constructor called");
	}
	
	public Account(int intialDeposit)
	{
		balance=intialDeposit;
		System.out.println("Parameterized Constructor called");
	}
	
	public Account(Account ac)
	{
		System.out.println("Copy constructor");
		this.balance=ac.balance;
		
	}
	
	public void deposit()
	{
		System.out.println("Enter the amount");
		Scanner sc=new Scanner(System.in);			
		balance+=sc.nextInt();
		System.out.println("Updated the balance");
	}
	
	public void showBalance()
	{
		System.out.println("Balance is :"+balance);
	}
	
	public void withdraw()
	{
		System.out.println("Enter the amount to withdraw");
		Scanner sc=new Scanner(System.in);
		int w=sc.nextInt();
		balance=balance-w;
	}
}
