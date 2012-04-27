package modele.elements;


import util.Ellipse;
import util.Bounding;

public class E_item extends Element
{
	public E_item (int x, int y, int size)
	{
		super (x,y,size);
		setBounding(new Bounding(new Ellipse(getPosition(),size+10,size+10)));
		setEtat (ATTRAPABLE);
	}

	public E_item ()
	{
		this (0,0,0);
	}
	
	public boolean entreEnCollision(Element el)
	{
		if  (bounding_.estEnCollision(el.getBounding()))
		{
			el.attrape (this);
			this.setEtat(ATTRAPER);
			collision();
			return true;
		}
		else
			return false;
	}

	public Element copie()
	{
		return new E_item (getPosition().getX(),getPosition().getY(),getSize());
	}
}
