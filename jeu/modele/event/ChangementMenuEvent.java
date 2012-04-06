package modele.event;

import javax.swing.JPanel;

import modele.Map;

public class ChangementMenuEvent
{
	/*
	 * Constantes
	 *
	 */
	public final static int PARTIE = 1;
	public final static int CONTINUER = 2;
	public final static int MENU_PRINCIPAL = 3;
	public final static int MENU_OPTIONS = 4;
	public final static int MENU_MAPS = 5;
	public final static int CHANGEMENT_MAP = 6;

	/*
	 * Les variables
	 *
	 */
	public JPanel panneau_actuel = null;
	public int num_menu;
	public Map nouvelle_carte = null;

	public ChangementMenuEvent(JPanel jp, int num_menu)
	{
		this.panneau_actuel = jp;
		this.num_menu = num_menu;
	}
	public Map getNouvelleCarte()
	{
		return nouvelle_carte;
	}
}
