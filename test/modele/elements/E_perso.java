package modele.elements;

import javax.swing.event.EventListenerList;

import modele.event.MouvementEvent;
import modele.listener.MouvementListener;

import util.Vector2f;
import util.Point2d;


public class E_perso 
{
	private int size_;
	private Point2d x_; // Position du personnage
	private Vector2f dx; // Vecteur dérivé de la position ( vitesse )
	private EventListenerList ecouteurs_;
	
	public E_perso (int x,int y, int s)
	{
		x_ = new Point2d(x,y);
		dx = new Vector2f();
		setSize(s);
		ecouteurs_ = new EventListenerList();
	}
	
	public E_perso ()
	{
		this (0,0,0);
	}

	
	/**
	 *		Ajout d'écouteur
	 */
	public void ajouterEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.add(MouvementListener.class, ml);
	}
	
	public void enleverEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.remove(MouvementListener.class, ml);
	}
	
	
	
	/**
	 *		Get/Set des champs privée de la classe
	 */
	public void setPosition (int x, int y) 
	{
		this.x_.setX(x);
		this.x_.setY(y);
		mouvement();
	}

	public Point2d getPosition ()
	{
		return x_;
	}

	public void setSize (int size)
	{
		this.size_ = size;
	}

	public int getSize ()
	{
		return size_;
	}

	public void setDx (float vi, float vj) 
	{
		dx.setI(vi);
		dx.setJ(vj);
	}

	public Vector2f getDx () 
	{
		return dx;
	}
	
	
	

	/**
	 *  	Déclencheur d'évenement
	 */
	private void mouvement ()
	{
        	MouvementListener[] ecouteurs = (MouvementListener[]) ecouteurs_.getListeners(MouvementListener.class);
        	for (MouvementListener ecouteur : ecouteurs)
        		ecouteur.enMouvement(new MouvementEvent(this, new Vector2f(getPosition().getX(),getPosition().getY())));
	}
}
