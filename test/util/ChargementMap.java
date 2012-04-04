package util;
import java.io.*;
import modele.Map;

public class ChargementMap
{
	protected String source;
	private Map m = null;

	public ChargementMap(String source)
	{
		this.source = source;
	}
	private void lecture() 
	{ 
		System.out.println("Fichier lu : " + this.source);
		try 
		{
			String ligne ;
			BufferedReader fichier = new BufferedReader(new FileReader(this.source));

			while ((ligne = fichier.readLine()) != null)
			{
				// Suppression des commentaires dans la ligne
				ligne = ligne.replaceAll("#.*$", "");

				// On ne fait rien avec les lignes vides
				if(ligne.length() > 1)
					System.out.println(ligne);
			}

			fichier.close();
		} 
		catch (Exception e) { e.printStackTrace(); }     
	}
	public Map getMap()
	{
		if(this.m == null)
			this.lecture();
		return m;
	}
}
