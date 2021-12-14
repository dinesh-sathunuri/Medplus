package Assignment;

public class Thread1 extends Thread {
	public void run()
	{
		for(int i=1;i<=60;i++)
		{
			System.out.print(i+" ");
			try
		{
				Thread.sleep(1000);//1 second =1000 milliseconds
		}
			catch(Exception e)
			{
				
			System.out.print(e);
		}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t = new Thread1();
		t.start();
		t.start();
	}

}
