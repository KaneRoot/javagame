package controleur;

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
		
		E_perso e = new E_perso(10,200,10);
		Map m = new Map(1000,300,e);
		
		m.addPoint(new Point2d(0,250));
		m.addPoint(new Point2d(200,200));
		m.addPoint(new Point2d(400,250));
		m.addPoint(new Point2d(600,200));
		m.addPoint(new Point2d(650,250));
		m.addPoint(new Point2d(800,250));
		
		m.getPerso().setPosition(m.getPerso().getPosition().getX(),
						m.getYSol(m.getPerso().getPosition().getX()));
		
		this.ctrlMap = new ControlerMap(m);
		this.ctrlMap.go();
		this.jp_partie = ctrlMap.getVue();

	}

	public void go()
	{
		this.jf_jeu.add(jp_menu);
		this.jf_jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jf_jeu.pack();
		this.jf_jeu.setVisible(true);
	}
	public void changerPanneau(ChangementMenuEvent e)
	{
		this.jf_jeu.remove(e.panneau_actuel);
		switch(e.num_menu)
		{
			case ChangementMenuEvent.PARTIE :
				this.jf_jeu.add(this.jp_partie);
				break;
			case ChangementMenuEvent.MENU_PRINCIPAL :
				this.jf_jeu.add(this.jp_menu);
			default :
				System.out.println("soucis au niveau du changement de menu");
				break;
		}
		this.jf_jeu.repaint();
		this.jf_jeu.pack();
	}
}
