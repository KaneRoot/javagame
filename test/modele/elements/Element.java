package modele.elements;
import  util.*;


public abstract class Element
{
	protected Point2d x_;		// Position de l'élement
	protected int size_;		// Taille de l'élement
	protected Bounding bounding;	// Zone d'influence
	
	public Element(Point2d p, int size, Bounding b)
	{	
		x_ = p;
		bounding = b;
		size_ = size;
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
}
