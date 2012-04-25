package controleur;

import controleur.thread.MouvementThread;
import controleur.thread.CollisionThread;

import modele.elements.*;
import util.Vector2f;
import modele.*;
import vue.*;
import vue.Vue;
import modele.event.*;

public class ControlerMap
{
	private MouvementThread thread1;
	private CollisionThread thread2;
	private Map map = null;
	private Vue vue = null;
	private ControleurMenu ctrlMenu;
	
	public ControlerMap(Map m, ControleurMenu c)
	{
		map = m;
		ctrlMenu = c;
		vue = new Vue(this,map.getPerso().getPosition().getX(),
				map.getPerso().getPosition().getY());
		map.ajouterEcouteurMouvement(vue);
		

		map.getPerso().ajouterEcouteurMouvement(vue);
		map.getPerso().ajouterEcouteurCollision(vue);
	
		for (int i=0; i<map.nbElem();i++)
		{
			map.getElem(i).ajouterEcouteurCollision (vue);
		}

		thread1 = new MouvementThread(map);   // Préparation de MouvementThread
		thread2 = new CollisionThread(map);
		thread2.start();
	}

	public ControleurMenu getCtrlMenu() { return ctrlMenu; }
	public Map getMap() { return map; }
	public Vue getVue() { return vue; }
	public void suspendre() { thread1.suspendre(); } 
	public void reprendre() { thread1.reprendre(); } 

	public void go()
	{
		vue.setVisible(true);
	}

	public void notifierMouvement(Vector2f v)
	{	
		if (map.getArrivee() <= map.getPerso().getPosition().getX() ||
					 map.getPerso().getEtat() != Element.MORT)
		{
			if (map.getPerso().getSac().size() >= 2 && map.getPerso().getEtat() != Element.MORT)
			{
				System.out.print ("Gagnée \n");
				ctrlMenu.changerPanneau(new ChangementMenuEvent(vue, 
							ChangementMenuEvent.GAGNE));
			}
			else
			{
				System.out.print ("Perdu \n");
				ctrlMenu.changerPanneau(new ChangementMenuEvent(vue, 
							ChangementMenuEvent.PERDU));
			}
		}
		else
		{
			map.getPerso().getDx().add(v);
			if (thread1.isNouveauNe())
				thread1.start();
			else if (thread1.isPause())
				thread1.reprendre();
		}
	}
}
