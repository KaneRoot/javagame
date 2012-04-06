package modele.event;

import javax.swing.JPanel;

import modele.Map;
import modele.event.*;

public class ChangementCarteEvent extends ChangementMenuEvent
{
	/**
	 * Les variables
	 *
	 */
	public Map nouvelle_carte;
	public ChangementCarteEvent(JPanel jp, int num_menu, Map m)
	{
		super(jp, num_menu);
		this.nouvelle_carte = m;
	}
	public Map getNouvelleCarte()
	{
		return nouvelle_carte;
	}
}
