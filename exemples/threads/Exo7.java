import java.lang.*;
import java.util.concurrent.*;

public class Exo7
{
	private ArrayBlockingQueue<Integer> mon_array;
	public static void main(String[] args)
	{
		ThreadGenerateur("Générateur", mon_array,
	}
	public void Creation()
	{
		int nombre = 100;
		try 
		{
			mon_array = new ArrayBlockingQueue<Integer>(nombre);
		
			for(int i = 2 ; i < nombre ; i++)
			{
				mon_array.put(i);
			}
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Erreur : " + e);
		}
	}
}

class ThreadGenerateur extends Thread
{
	ArrayBlockingQueue<Integer> mon_array;
	int borne;
	int compteur = 2;
	
	public ThreadGenerateur(String nom, ArrayBlockingQueue array, int Borne)
	{
		super(nom);
		this.mon_array = array;
		this.borne = Borne;
	}
}
class TFiltre extends Thread
{
	
}
