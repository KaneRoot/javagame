package util;
import java.io.*;
import modele.Map;
import modele.elements.*;
import modele.elements.E_fixe;
import modele.elements.E_perso;

public class ChargementMap
{
	protected String source;
	private Map m = null;

	public ChargementMap(String source)
	{
		this.source = source;
	}

	private int testLigne(String ligne)
	{
		String[] options = ligne.split(":");
		switch(options[0])
		{
			case "nom" :
				this.m.setNom(options[1]);
				break;
			case "taille" :
				try 
				{ 
					this.m.setW(getInt(options[1]));
					this.m.setH(getInt(options[2]));
				}
				catch(Exception e) { return -1; }
				break;
			case "arrivee" :
				try
				{
					this.m.setArrivee(getInt(options[1]));
				}
				catch(Exception e) { return -1; }
				break;
			case "sol" :
				try
				{
					this.m.addPoint(new Point2d(getInt(options[1]), getInt(options[2])));
				}
				catch(Exception e) { return -1; }
				break;

			case "perso" :
				// System.out.println("On crée le perso ! " + options[1]);
				try
				{
					Class c = Class.forName("modele.elements." + options[1]);
					E_perso p = (E_perso) c.newInstance();
					p.setPosition(getInt(options[2]), getInt(options[3]));
					p.setSize(getInt(options[4]));
					this.m.setPerso(p);
				}
				catch(Exception e) { System.out.println("Erreur création du perso"); return -1; }

				break;
			default :
				try
				{
					Class c = Class.forName("modele.elements." + options[0]);
					Element e = (Element) c.newInstance();
					e.setPosition(getInt(options[1]), getInt(options[2]));
					e.setSize(getInt(options[3]));
					this.m.addElem(e);
				}
				catch(Exception e) 
				{
					e.printStackTrace(); 
					System.out.println("Option inconnue : " + options[0]);
					return -1; 
				}
		}
		return 0;
	}

	private void lecture() 
	{ 
		this.m = new Map();
		// System.out.println("Fichier lu : " + this.source);
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
					if( -1 == testLigne(ligne))
						System.out.println("Il y a eu une erreur à la ligne : " + ligne);
			}

			if( this.m.getNom() == null)
				this.m.setNom(this.source);

			this.m.getPerso().setPosition(this.m.getPerso().getPosition().getX(), 
					this.m.getYSol(m.getPerso().getPosition().getX()));

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

	private int getInt(String s)
	{
		int i;

		try { i = Integer.parseInt(s); }
		catch(NumberFormatException e) { return -1; }
		return i;
	}
}
