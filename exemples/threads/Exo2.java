import java.lang.*;

public class Exo2 
{
	public static void main (String[] args)
	{
		Thread rapide, dodo, actif;
		rapide = new Thread();
		actif = new ThreadActif("Actif");
		dodo = new ThreadDodo("Dodo");
		System.out.println("Début du main");
		System.out.println("Sans lancer le thread : " + rapide.getState());
		
		actif.start();
		rapide.start();
		dodo.start();
				
		try
		{
			Thread.sleep(100);
		}
		catch(InterruptedException ie)
		{
			System.out.println("Petit soucis");
		}
		
		System.out.println("Dodo : " + dodo.getState());
		System.out.println("Rapide : " + rapide.getState());
		
	}
}
class ThreadActif extends Thread
{
	public ThreadActif ( String nom)
	{
		super(nom);
	}
	@Override
	public void run()
	{
		System.out.println("Actif : " + this.getState());
	}
}
class ThreadDodo extends Thread
{
	public ThreadDodo ( String nom)
	{
		super(nom);
	}
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch( InterruptedException ie)
		{
			System.out.println("Attention, ça a planté");
		}
	}
}
