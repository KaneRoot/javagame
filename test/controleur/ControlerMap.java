package controleur;

import controleur.thread.MouvementThread;

import util.Vector2f;
import vue_modele.Map; // inutile là.
import vue_modele.*;

public class ControlerMap
{
	private MouvementThread thread;
	private Map map = null;
	private Vue vue = null;
	
	public ControlerMap(Map m)
	{
		map = m;
		vue = new Vue(this,map.getPerso().getX(),map.getPerso().getY());
		map.ajouterEcouteurMouvement(vue);
		map.getPerso().ajouterEcouteurMouvement(vue);
		thread = new MouvementThread(map,null);
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public void go()
	{
		vue.setVisible(true);
	}
	
	public void notifierMouvement(Vector2f v)
	{
		//MouvementThread thread = new MouvementThread(map,1,v);
		thread.setVector(v);
		thread.start();
	}
	
	/*
	public void notifierSaut(Vector2f v)
	{
		MouvementThread thread = new MouvementThread(map,2,v);
		thread.start();
	}
	*/
}
