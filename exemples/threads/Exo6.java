import java.lang.*;
import java.util.Scanner;

public class Exo6
{
	public static void main(String[] args)
	{
		TDemanderNom t = new TDemanderNom("Le Thread pour demander le nom");
		t.start();
		try
		{
			Thread.sleep(5000);
			if(t.getNom().equals(""))
			{
				System.out.println("Vous avez été trop lent");
				System.exit(0);
			}
			else
			{
				System.out.println("Votre nom est : " + t.getNom());
			}
		}
		catch ( InterruptedException e )
		{
			System.out.println("Il y eu un bon kill sur ce Thread");
		}
		
	}
}
class TDemanderNom extends Thread
{
	String bla = "";
	public TDemanderNom(String nom)
	{
		super(nom);
	}
	@Override
	public void run()
	{
		System.out.print("Votre nom : ");

		Scanner sc = new Scanner(System.in);
		this.bla = sc.nextLine();
		
	}
	public String getNom()
	{
		return this.bla;
	}
}
