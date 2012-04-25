package modele.elements;

import util.Bounding;
import util.Ellipse;

import modele.elements.Element;

public class E_lethal extends Element
{
	public E_lethal (int x, int y, int size)
	{
		super (x,y,size);
		setBounding(new Bounding(new Ellipse(getPosition(),size+10,size+10)));
		setEtat (PLEINEVIE);
	}
	public E_lethal()
	{
		this(0,0,0);
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
