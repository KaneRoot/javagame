package modele.elements;
<<<<<<< HEAD
=======

import util.Bounding;
import util.Ellipse;

>>>>>>> aa29a7ae4d225438f18d3c0ea15ce4dd74bdb95a

import modele.elements.Element;

public class E_lethal extends Element
{
	public E_lethal (int x, int y, int size)
	{
		super (x,y,size);
		setBounding(new Bounding(new Ellipse(getPosition(),size+10,size+10)));
		setEtat (PLEINEVIE);
	}

	public boolean entreEnCollision(Element el)
	{
		if  (bounding_.estEnCollision(el.getBounding()))
		{
			el.setEtat(MORT);
			collision();
			return true;
		}
		else
			return false;
	}

}
