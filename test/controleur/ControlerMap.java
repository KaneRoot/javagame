package controleur;

import controleur.thread.MouvementThread;

import util.Vector2f;
import modele.*;
import vue.*;
import vue.Vue;

public class ControlerMap
{
	private MouvementThread thread;
	private Map map = null;
	private Vue vue = null;
	private ControleurMenu ctrlMenu;
	
	public ControlerMap(Map m, ControleurMenu c)
	{
		map = m;
		ctrlMenu = c;
		vue = new Vue(this,map.getPerso().getPosition().getX(),map.getPerso().getPosition().getY());
		map.ajouterEcouteurMouvement(vue);
		map.getPerso().ajouterEcouteurMouvement(vue);
		thread = new MouvementThread(map,null);
	}
	public ControleurMenu getCtrlMenu()
	{
		return ctrlMenu;
	}
	public Map getMap()
	{
		return map;
	}
	public Vue getVue()
	{
		return vue;
	}
	public void go()
	{
		vue.setVisible(true);
	}
	public void notifierMouvement(Vector2f v)
	{
		//MouvementThread thread = new MouvementThread(map,1,v);
		thread.setVector(v);
		if (!thread.isAlive())
		{
			thread.start();
		}
	}
	
	/*
	public void notifierSaut(Vector2f v)
	{
		MouvementThread thread = new MouvementThread(map,2,v);
		thread.start();
	}
	*/
}
