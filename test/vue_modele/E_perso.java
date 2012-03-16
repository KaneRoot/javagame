package vue_modele;

import javax.swing.event.EventListenerList;

import evenement.MouvementEvent;
import evenement.MouvementListener;

import util.Vector2f;


public class E_perso 
{
	private int x_,y_,size_;
	private Vector2f dx; // Vecteur dérivé de la position ( vitesse )
	private EventListenerList ecouteurs_;
	
	public E_perso (int x,int y, int s)
	{
		x_ = x;
		y_ = y;
		setSize(s);
		ecouteurs_ = new EventListenerList();
	}
	
	public E_perso ()
	{
		this (0,0,0);
	}

	
	public void ajouterEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.add(MouvementListener.class, ml);
	}
	
	
	public void enleverEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.remove(MouvementListener.class, ml);
	}
	
	
	/**
	 *    Get/Set des champs privée de la classe
	 */
	public void setX(int x) 
	{
		this.x_ = x;
		mouvement();
	}

	public int getX()
	{
		return x_;
	}

	public void setY(int y)
	{
		this.y_ = y;
		mouvement();
	}

	public int getY()
	{
		return y_;
	}

	public void setSize(int size)
	{
		this.size_ = size;
	}

	public int getSize()
	{
		return size_;
	}

	public void setDx(Vector2f dx) 
	{
		this.dx = dx;
	}

	public Vector2f getDx() 
	{
		return dx;
	}
	
	
	
	/**
	 *  	Déclencheur d'évenement
	 */
	private void mouvement()
	{
        MouvementListener[] ecouteurs = (MouvementListener[]) ecouteurs_.getListeners(MouvementListener.class);
        for (MouvementListener ecouteur : ecouteurs)
        	ecouteur.enMouvement(new MouvementEvent(this, new Vector2f(x_,y_)));
	}

	
	
}
