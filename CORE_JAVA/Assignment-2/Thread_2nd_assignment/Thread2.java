package Assignment;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Thread2 implements Runnable{
	int i;
	public void run()
	{
		for(i=1;i<=60;i++)
		{
			System.out.println(Thread.currentThread().getName()+":"+i);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int time=sc.nextInt();
		int n=100/time;
		ExecutorService executor = Executors.newFixedThreadPool(n);  
        for (int i = 0; i < 100; i++) {
            Runnable worker = new Thread2();
            executor.execute(worker);
          }
        sc.close();
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
	}
}

