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
	public JPanel jp_menu = null ;
	public JPanel jp_partie = null ;
	public JPanel jp_maps = null ;
	public JFrame jf_jeu = null ;
	public E_perso personnage = null ;
	public ControlerMap ctrlMap = null ;


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
<<<<<<< HEAD
		E_perso pers = new E_perso(10,200,10);
		Map m = new Map(1000,300,pers);
		E_fixe e = new E_fixe(200,100,20);

		m.addPoint(new Point2d(0,250));
		m.addPoint(new Point2d(200,200));
		m.addPoint(new Point2d(400,250));
		m.addPoint(new Point2d(600,200));
		m.addPoint(new Point2d(650,250));
		m.addPoint(new Point2d(800,250));
		m.addPoint(new Point2d(900,245));
		m.addPoint(new Point2d(1500,100));
		m.addPoint(new Point2d(5000,300));
		m.getPerso().setPosition(m.getPerso().getPosition().getX(),
			m.getYSol(m.getPerso().getPosition().getX()));
		
		m.addElem(e);
=======
		ChargementMap c = new ChargementMap("./maps/FichierValable");
		Map m = c.getMap();
>>>>>>> 1a22f9246a0b6568e860f9ebe394f5ee62f505d3

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
		System.out.println("On passe ici !");
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
				System.out.println("Demande de chargement de maps");
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
