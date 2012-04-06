package controleur;

import java.awt.KeyboardFocusManager;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;

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
	public JPanel jp_menu = null ;
	public JPanel jp_partie = null ;
	public JPanel jp_maps = null ;
	public JFrame jf_jeu = null ;
	public ControlerMap ctrlMap = null ;
	public Map carte_courante = new ChargementMap("./maps/FichierValable").getMap();
	public static final String repertoire_cartes = "./maps";

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
		this.ctrlMap = new ControlerMap(this.carte_courante, this);
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
			this.reprendrePartie();
			this.jp_partie.setVisible(true);
			this.jp_partie.requestFocus();	
		}
	}

	public void changerPanneau(ChangementMenuEvent e)
	{
		if(e.panneau_actuel != null)
			e.panneau_actuel.setVisible(false);
		else
			System.out.println("Il y a un soucis : panneau_actuel à null !!!!!!");

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
				resumePartie();
				break;
			case ChangementMenuEvent.MENU_MAPS :
				choixMap();
				break;
			case ChangementMenuEvent.CHANGEMENT_MAP :
				this.carte_courante = e.getNouvelleCarte();
				startPartie();
				break;
			default :
				System.out.println("soucis au niveau du changement de menu");
				break;
		}
		this.jf_jeu.repaint();
	}

	private  void reprendrePartie() { this.ctrlMap.reprendre(); }

	private void mettreEnPause() { this.ctrlMap.suspendre(); }

	private void choixMap()
	{
		if(this.jp_maps == null)
		{
			this.jp_maps = new MenuCartes(this, repertoire_cartes);
			this.jf_jeu.add(jp_maps);
		}

		this.jp_maps.setVisible(true);
	}
}
