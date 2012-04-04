package util;
import java.io.*;

public class ChargementMap
{
	protected String source;

	public ChargementMap(String source)
	{
		this.source = source;
		lecture();
	}
	private void lecture() 
	{ 
		try 
		{
			String ligne ;
			BufferedReader fichier = new BufferedReader(new FileReader(this.source));

			while ((ligne = fichier.readLine()) != null)
				System.out.println(ligne);

			fichier.close();
		} 
		catch (Exception e) { e.printStackTrace(); }     
	}
}
