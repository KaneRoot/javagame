package modele.elements;

import javax.swing.event.EventListenerList;

import modele.event.MouvementEvent;
import modele.listener.MouvementListener;

import util.Vector2f;
import util.Point2d;


public class E_perso extends Element
{
	private Vector2f dx; // Vecteur vitesse
	private EventListenerList ecouteurs_;
	
	public E_perso (int x,int y, int s)
	{
		super(x,y,s);
		dx = new Vector2f();
		ecouteurs_ = new EventListenerList();
	}
	
	public E_perso ()
	{
		this (0,0,0);
	}

	/**
	 *		Ajout d'écouteur
	 */
	public void ajouterEcouteurMouvement(MouvementListener ml)
	{
		ecouteurs_.add(MouvementListener.class, ml);
	}
	
	public void enleverEcouteurMouvement(MouvementListener ml)
	{
		ecouteurs_.remove(MouvementListener.class, ml);
	}
	
	public void setDx(float vi, float vj) 
	{
		dx.setI(vi);
		dx.setJ(vj);
	}
	
	public void setPosition(int x, int y) 
	{
		this.x_.setX(x);
		this.x_.setY(y);
		mouvement();
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
        	MouvementListener[] ecouteurs = (MouvementListener[]) ecouteurs_.getListeners(
										MouvementListener.class);
        	for (MouvementListener ecouteur : ecouteurs)
        		ecouteur.enMouvement(new MouvementEvent(this, 
						new Vector2f(getPosition().getX(), getPosition().getY())));
	}
}
