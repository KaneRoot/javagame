package modele.listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vue.menu.*;
import modele.event.*;
import controleur.*;
import modele.*;

public class JBMapListener implements ActionListener
{
	ControleurMenu c;
	MenuCartes m;
	Map carte;

	// x = numéro de la map
	public JBMapListener(ControleurMenu c, MenuCartes m, Map carte)
	{
		this.c = c;
		this.m = m;
		this.carte = carte;
	}
	public void actionPerformed(ActionEvent e)
	{
		ChangementMenuEvent event;
		event = new ChangementCarteEvent(m, ChangementMenuEvent.CHANGEMENT_MAP, carte);
		this.c.changerPanneau(event);
	}
}
