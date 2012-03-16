package controleur;

import thread.MouvementThread;
import util.Vector2f;
import vue_modele.Map;
import vue_modele.Vue;

public class ControlerMap
{
	private Map map = null;
	private Vue vue = null;
	
	public ControlerMap(Map m)
	{
		map = m;
		vue = new Vue(this,map.getStick().getX(),map.getStick().getY());
		map.ajouterEcouteurMouvement(vue);
		map.getStick().ajouterEcouteurMouvement(vue);
	}
	
	public void go()
	{
		vue.setVisible(true);
	}
	
	public void notifierMouvement(Vector2f v)
	{
		MouvementThread thread = new MouvementThread(map,1,v);
		thread.start();
	}
	
	public void notifierSaut(Vector2f v)
	{
		MouvementThread thread = new MouvementThread(map,2,v);
		thread.start();
	}
}
