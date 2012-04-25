package modele.elements;

import java.util.ArrayList;
import java.awt.image.BufferedImage;

import util.*;
import modele.event.CollisionEvent;
import modele.listener.CollisionListener;


public abstract class Element
{
	/**
	*  Champs static décrivant l'etat de l'element
	**/
	public static int MORT = 0;
	public static int ATTRAPABLE = -2;
	public static int ATTRAPER = -3;
	public static int INVISIBLE = -1;
	public static int INVINSIBLE = -10;
	public static int PLEINEVIE = 100;


	/**
	*  Champs en mode protected; décrivant les proprietes de l'element
	**/
	protected Point2d x_;			// Position de l'élement
	protected int size_;			// Taille de l'élement
	protected Bounding bounding_;		// Zone d'influence

	protected ArrayList<CollisionListener> collisionEcouteurs_; // Ecouteurs d'évenement
	protected ArrayList<BufferedImage> image;
	protected ArrayList<Element> sac;

	protected int currentImage;
	protected int etat;
	
	public Element(Point2d p, int size, Bounding b)
	{		
		this (p,size,b,new ArrayList<BufferedImage>(1));
	}

	public Element(Point2d p, int size, Bounding b, ArrayList<BufferedImage> im)
	{
		collisionEcouteurs_ = new ArrayList<CollisionListener>(1);
		x_ = p;
		bounding_ = b;
		size_ = size;
		image = im;
		currentImage = 0;
		sac = new ArrayList<Element>(1);
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
		setBounding(new Bounding(new Rectangle(x_,size_,size_)));
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

	public void addImage (BufferedImage im)
	{
		image.add (im);
	}

	public BufferedImage getImage (int i)
	{
		return image.get (i);
	}
	
	public int nbImage ()
	{
		return image.size();
	}

	public int getCurrentImage()
	{
		return currentImage;
	}
	
	public void setCurrentImage(int c)
	{
		currentImage = c;
	}

	public abstract boolean entreEnCollision(Element el);
	
	public void collision()
	{	
		for (int i=0;i<collisionEcouteurs_.size();i++)
			collisionEcouteurs_.get(i).enCollision(new CollisionEvent(this,null));
	}

	public int getEtat()
	{
		return etat;
	} 	
	
	public void setEtat(int etat)
	{
		this.etat = etat;
	}	

	public ArrayList<Element> getSac()
	{
		return sac;
	}
	
	public void attrape (Element e)
	{
		sac.add (e);
	}	

	public void setOptions (String[] options)
	{
		for (String s:options)
		{	
			if (s.compareTo (""))
			{
			}
			else if 
		}
	}

}
