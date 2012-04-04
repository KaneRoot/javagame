package modele.elements;

import java.util.ArrayList;
import util.*;
import modele.event.CollisionEvent;
import modele.listener.CollisionListener;


public abstract class Element
{
	protected Point2d x_;			// Position de l'élement
	protected int size_;			// Taille de l'élement
	protected Bounding bounding_;		// Zone d'influence
	protected ArrayList<CollisionListener> collisionEcouteurs_; // Ecouteurs d'évenement
	
	public Element(Point2d p, int size, Bounding b)
	{		
		collisionEcouteurs_ = new ArrayList<CollisionListener>(1);
		x_ = p;
		bounding_ = b;
		size_ = size;
	}	

	public void ajouterEcouteurCollision(CollisionListener cl)
	{
		collisionEcouteurs_.add(cl);
	}	

	public void envleverEcouteurCollision(CollisionListener cl)
	{
		collisionEcouteurs_.remove(cl);
	}

	public Element(int x, int y, int size)
	{
		this(new Point2d(x,y), size, null);
	}

	public void setPosition(int x, int y) 
	{
		this.x_.setX(x);
		this.x_.setY(y);
	}

	public Point2d getPosition()
	{
		return x_;
	}

	public void setSize(int size)
	{
		this.size_ = size;
	}

	public int getSize()
	{
		return size_;
	}
	
	public void setBounding(Bounding b)
	{
		bounding_ = b;
	}
	
	public Bounding getBounding()
	{
		return bounding_;
	}

	public abstract boolean entreEnCollision(Element el);
	
	public void collision()
	{	
		for (int i=0;i<collisionEcouteurs_.size();i++)
			collisionEcouteurs_.get(i).enCollision(new CollisionEvent(this,null));
	}	
	
}
