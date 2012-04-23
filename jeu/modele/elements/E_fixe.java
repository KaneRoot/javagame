package modele.elements;

import util.*;

public class E_fixe extends Element
{
	public E_fixe(int x, int y, int size, Bounding b)
	{
		super(x,y,size);
		setBounding(new Bounding(new Ellipse(getPosition(),size+10,size+10)));
	}

	public E_fixe(int x, int y, int size)
	{
		this(x,y,size,null);
	}

	public E_fixe()
	{
		this(0,0,0);
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
	}
}
