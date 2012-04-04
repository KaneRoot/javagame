package modele.elements;

import modele.event.MouvementEvent;
import modele.listener.MouvementListener;
import util.*;
import java.util.*;


public class E_perso extends Element
{
	private Vector2f dx; // Vecteur vitesse
	private ArrayList<MouvementListener> mouvementEcouteurs_;	

	public E_perso (int x,int y, int size)
	{
		super(x,y,size);
		mouvementEcouteurs_ = new ArrayList<MouvementListener>(1);
		dx = new Vector2f();
		setBounding(new BoundingEllipse(new Ellipse(x_,50,50)));
	}
	
	public E_perso ()
	{
		this (0,0,0);
	}

	public void ajouterEcouteurMouvement(MouvementListener ml)
	{
		mouvementEcouteurs_.add(ml);
	}
	
	public void enleverEcouteurMouvement(MouvementListener ml)
	{
		mouvementEcouteurs_.remove(ml);
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
	

	public boolean entreEnCollision(Element el)
	{

		if  (bounding_.estEnCollision(el.getBounding()))
		{
			collision();
			return true;
		}
		else
			return false;
   	 /*	collision();
		return true;*/

	}


	/** Déclenche evenement mouvement **/
	private void mouvement()
	{
        	for (int i=0;i<mouvementEcouteurs_.size();i++)
        		mouvementEcouteurs_.get(i).enMouvement(new MouvementEvent(this, 
						new Vector2f(getPosition().getX(), getPosition().getY())));
	}



}
