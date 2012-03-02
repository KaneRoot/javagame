import java.lang.*;

public class JeTeste
{
	public static void main(String[] args)
	{
		MonThreadAssezLong t1 = new MonThreadAssezLong("LePremier");
		MonThreadAssezLong t2 = new MonThreadAssezLong("LeSecond");
		
		try
		{
			t1.start();
			t1.join();
		
			t2.start();
			t2.join();
		}
		catch(InterruptedException ie)
		{
			System.out.println("L'un des threads a été interrompu");
		}
		System.out.println("fin");
	
	}
}

class MonThreadAssezLong extends Thread
{
	public MonThreadAssezLong(String bla)
	{
		super(bla);
	}
	@Override
	public void run()
	{
		int i = 0;
		while( i < 4)
		{
			try
			{
				Thread.sleep(500);	
				System.out.println("Je suis : " + Thread.currentThread().getName());
			}
			catch(InterruptedException ie)
			{
				System.out.println("Nous avons un problème");
			}
			i++;
		}
	}
}
