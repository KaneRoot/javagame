package modele.elements;

import  util.*;
import javax.swing.event.EventListenerList;
import modele.event.CollisionEvent;
import modele.listener.CollisionListener;


public abstract class Element
{
	protected Point2d x_;		// Position de l'élement
	protected int size_;		// Taille de l'élement
	protected Bounding bounding_;	// Zone d'influence
	protected EventListenerList ecouteurs_;
	
	public Element(Point2d p, int size, Bounding b)
	{		
		ecouteurs_ = new EventListenerList();
		x_ = p;
		bounding_ = b;
		size_ = size;
	}	

	public Element(int x, int y, int size)
	{
		this(new Point2d(x,y), size, null);
	}

	public Element()
	{
		this(0,0,0);
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

}
