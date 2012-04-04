package util;
import java.io.*;
import model.Map;

public class ChargementMap
{
	protected String source;
	private Map m = null;

	public ChargementMap(String source)
	{
		this.source = source;
		lecture();
	}
	private void lecture() 
	{ 
		System.out.println("Fichier lu : " + this.source);
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
	public Map getMap()
	{
		if(this.m == null)
			this.lecture();
		return m;
	}
}
