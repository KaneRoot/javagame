import java.lang.*;

public class Exo4
{
	public static void main(String[] args)
	{
		int bla = 0;
		try
		{
			bla = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Problème d'argument ! ");
			bla = 10;
		}
		
		for(int i = 1 ; i <= bla ; i++)
		{
			UnThread unNouveauThread = new UnThread("Thread" + i);
			unNouveauThread.setPriority(Thread.MAX_PRIORITY);
			unNouveauThread.start();
		}
	}
}
class UnThread extends Thread
{
	public UnThread(String nom)
	{
		super(nom);
	}
	@Override
	public void run()
	{
		System.out.println("Nom du thread courrant : " + Thread.currentThread().getName());
	}
}
