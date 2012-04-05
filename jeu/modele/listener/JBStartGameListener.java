package modele.listener;

import vue.menu.Menu;
import modele.event.ChangementMenuEvent;
import controleur.ControleurMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JBStartGameListener implements ActionListener
{
	ControleurMenu c;
	Menu m;

	public JBStartGameListener(ControleurMenu c, Menu m)
	{
		this.c = c;
		this.m = m;
	}
	public void actionPerformed(ActionEvent e)
	{
		ChangementMenuEvent event = new ChangementMenuEvent(m, ChangementMenuEvent.PARTIE);
		this.c.changerPanneau(event);
	}
}
