package modele.listener;

import vue.menu.Menu;
import modele.event.ChangementMenuEvent;
import controleur.ControleurMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JBResumeListener implements ActionListener
{
	ControleurMenu c;
	Menu m;

	public JBResumeListener(ControleurMenu c, Menu m)
	{
		this.c = c;
		this.m = m;
	}
	public void actionPerformed(ActionEvent e)
	{
		ChangementMenuEvent event = new ChangementMenuEvent(m, ChangementMenuEvent.RECOMMENCER);
		this.c.changerPanneau(event);
	}
}
