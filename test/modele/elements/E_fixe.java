package modele.elements;

import util.*;

public class E_fixe extends Element
{
	public E_fixe(int x, int y, int size, Bounding b)
	{
		super(x,y,size);
	}

	public E_fixe(int x, int y, int size)
	{
		this(x,y,size,null);
	}
	public E_fixe()
	{
		this(0,0,0);
	}
}
