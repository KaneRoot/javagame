package modele.event;

import javax.swing.JPanel;

public class ChangementMenuEvent
{
	/*
	 * Constantes
	 *
	 */
	public final static int PARTIE = 1;
	public final static int MENU_PRINCIPAL = 2;
	public final static int MENU_OPTIONS = 3;

	/*
	 * Les variables
	 *
	 */
	public JPanel panneau_actuel = null;
	public int num_menu;

	public ChangementMenuEvent(JPanel jp, int num_menu)
	{
		this.panneau_actuel = jp;
		this.num_menu = num_menu;
	}
}
