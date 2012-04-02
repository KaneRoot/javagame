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
		vue = new Vue(this,map.getPerso().getPosition().getX(),
				map.getPerso().getPosition().getY());
		map.ajouterEcouteurMouvement(vue);
		map.getPerso().ajouterEcouteurMouvement(vue);
		thread = new MouvementThread(map);   // Préparation de MouvementThread
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

	public void pause()
	{
		try
		{
			thread.pause();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void go()
	{
		vue.setVisible(true);
	}

	public void notifierMouvement(Vector2f v)
	{	
		map.getPerso().getDx().add(v);
		if (thread.isNouveauNe())
			thread.start();
		else if (thread.isPause())
			thread.reprendre();
	}

	public MouvementThread getMouvementThread()
	{
		return thread;
	}
}
