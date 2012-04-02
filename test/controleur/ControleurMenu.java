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
		E_perso pers = new E_perso(10,200,10);
				Map m = new Map(1000,300,pers);

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
				this.ctrlMap = new ControlerMap(m, this);
				this.ctrlMap.go();
		this.jp_partie = ctrlMap.getVue();
		//this.jf_jeu.setFocusTraversalKeysEnabled(true);
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
				this.mettreEnPause();
				this.jp_menu.setVisible(true);
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
		//this.jf_jeu.pack();
	}
	public  void reprendrePartie()
	{
		try
		{
			this.ctrlMap.getMouvementThread().reprendre();
		}
		catch(Exception e)
		{
			System.out.println("Exception pause du thread");
		}
	}
	public void mettreEnPause()
	{
		try
		{
			this.ctrlMap.getMouvementThread().pause();
		}
		catch(Exception e)
		{
			System.out.println("Exception pause du thread");
		}
	}
}
