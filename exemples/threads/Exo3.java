import java.lang.*;

public class Exo3
{
	public static void main(String[] args)
	{
		int ma_valeur = Integer.parseInt(args[0]);
		ThreadCompteur compteurPremier, compteurSecond;
		compteurPremier = new ThreadCompteur("Premier",ma_valeur,Thread.MAX_PRIORITY);
		compteurSecond = new ThreadCompteur("Second",ma_valeur,Thread.MIN_PRIORITY);
		
		compteurPremier.start();
		compteurSecond.start();
	}
}
class ThreadCompteur extends Thread
{
	int k = 1;
	int val_max;
	public ThreadCompteur(String nom, int max, int prio)
	{
		super(nom);
		this.val_max = max;
		this.setPriority(prio);
	}
	@Override
	public void run()
	{
		while( k < val_max)
		{
			System.out.println(Thread.currentThread().getName() + " : " + k);
			k++;
		}
	}
}
