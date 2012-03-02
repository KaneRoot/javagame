import java.lang.*;

public class Exo5
{
	public static void main(String[] args)
	{
		int nombreMax = 2;
		try
		{
			nombreMax = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Erreur d'argument :/");
			nombreMax = 10;
		}
		catch ( ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Erreur : " + e);
			nombreMax = 10;
		}
		leThread bla = new leThread("bla",nombreMax);
		bla.start();
	}
}
class leThread extends Thread
{
	int i = 0;
	int nombreMax = 0;
	public leThread(String nom, int max)
	{
		super(nom);
		this.nombreMax = max;
	}
	@Override
	public void run()
	{
		while( i < nombreMax)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch ( InterruptedException e )
			{
				System.out.println("Il y eu un bon kill sur ce Thread");
			}
			System.out.println("Mon i " + i);
			i++;
		}
	}
}
