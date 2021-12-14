package bank;
import java.util.Scanner;
class withdrawerrorException extends Exception
{
	withdrawerrorException(String s){
		super(s);
	}
}
public class Banking {
	private int balance;
	private String holdername;
	private long number;
	int count=0;
	Banking(String n,long no)
	{
		balance=1000;
		holdername=n;
		number=no;
	}
	public void get()
	{
		System.out.println("Your "+number+" account balance :"+balance);
	}
	public void deposit(int add)
	{
		balance+=add;//adding deposit money to account
		System.out.println(add+" amount is deposited to "+number+" account");
	}
	public void withdraw(int sub) throws withdrawerrorException 
	{
		if(sub>balance)
		{
			throw new withdrawerrorException("Withdraw amount should be less than balance");
		}
		else if(count<3)//checking max 3 withdraws only
		{
			balance-=sub;
			count++;//updating withdraw
			System.out.println(sub+" amount is withdraw from "+number+" account");
		}
		else
		{
			throw new withdrawerrorException("You can withdraw 3 times max in a day");
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int choice,depo,with;
		long accno;
		String name;
		System.out.println("ENTER NAME");
		name=sc.nextLine();
		System.out.println("ENTER ACCOUNT NO");
		accno=sc.nextInt();
		Banking acc1=new Banking(name,accno);
		while(true)
		{
			System.out.print("1.DEPOSIT AMOUNT\n2.WITHDRAW AMOUNT\n3.GET BALANCE\n4.EXIT\nENTER YOUR CHOICE");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.print("Please enter the amount to be deposited :");
					depo=sc.nextInt();
					acc1.deposit(depo);
					break;
			case 2:try
			{
					System.out.print("Please enter the amount to be withdrawn :");
					with=sc.nextInt();
					acc1.withdraw(with);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			break;
			case 3:acc1.get();
					break;
			case 4: sc.close();
					System.exit(0);
			default:System.out.println("With in the choice only");
			}
		}
	}
}