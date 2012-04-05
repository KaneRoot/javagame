package controleur;

import java.awt.KeyboardFocusManager;
import javax.swing.JPanel;
import javax.swing.JFrame;

import vue.menu.Menu;
import util.*;
import modele.*;
import modele.event.*;
import modele.elements.*;
import vue.*;
import vue.menu.*;
import controleur.thread.*;


public class ControleurMenu 
{
	public JPanel jp_menu;
	public JPanel jp_partie;
	public JPanel jp_maps;
	public JFrame jf_jeu;
	public E_perso personnage;
	public ControlerMap ctrlMap;


	public ControleurMenu()
	{
		this.jf_jeu = new JFrame();
		this.jp_menu = new Menu(this);
	}

	public void go()
	{
		this.jf_jeu.add(jp_menu);
		this.jf_jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jf_jeu.pack();
		this.jf_jeu.setVisible(true);
	}

	private void startPartie()
	{
		ChargementMap c = new ChargementMap("./maps/FichierValable");
		Map m = c.getMap();

		this.ctrlMap = new ControlerMap(m, this);
		this.ctrlMap.go();
		this.jp_partie = ctrlMap.getVue();
		this.jf_jeu.add(this.jp_partie);
		this.jp_partie.requestFocus();	
		this.jf_jeu.setSize(1000,500);	
		this.ctrlMap.getVue().setSize(1000,500);
		
		this.jp_partie.setVisible(true);
	}

	private void resumePartie()
	{
		if(this.jp_partie == null)
			startPartie();
		else
		{
			this.jp_partie.setVisible(true);
			this.jp_partie.requestFocus();	
		}
	}

	public void changerPanneau(ChangementMenuEvent e)
	{
		e.panneau_actuel.setVisible(false);
			
		switch(e.num_menu)
		{
			case ChangementMenuEvent.PARTIE :
				startPartie();
				break;
			case ChangementMenuEvent.MENU_PRINCIPAL :
				this.jp_menu.setVisible(true);
				this.mettreEnPause();
				break;
			case ChangementMenuEvent.CONTINUER :
				this.reprendrePartie();
				resumePartie();
				break;
			default :
				System.out.println("soucis au niveau du changement de menu");
				break;
		}
		this.jf_jeu.repaint();
	}

	public  void reprendrePartie()
	{
		this.ctrlMap.getMouvementThread().reprendre();
	}

	public void mettreEnPause()
	{
		this.ctrlMap.getMouvementThread().suspendre();
	}
}
