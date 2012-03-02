import java.lang.*;


public class Exo1 extends Thread
{
	public static void main (String[] args)
	{
		System.out.println("toString du thread courant : " + Thread.currentThread());
		System.out.println("nom : " + Thread.currentThread().getName());
		System.out.println("priorité : " + Thread.currentThread().getPriority());
		System.out.println("État : " + Thread.currentThread().getState());		
	}
}
