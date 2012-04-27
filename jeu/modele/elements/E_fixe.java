package modele.elements;

import util.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

public class E_fixe extends Element
{
	public E_fixe(int x, int y, int size, Bounding b)
	{
		super(x,y,size);
		setBounding(new Bounding(new Ellipse(getPosition(),size,size)));

		try
		{
			addImage (ImageIO.read (new File("./image/fixe1.png")));
		}
		catch (IOException e)
		{
			//TODO
		}
		setEtat (PLEINEVIE);
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
	
	public Element copie ()
	{
		return new E_fixe (this.getPosition().getX(),
					this.getPosition().getY(),
					this.getSize(),
					this.getBounding());
	}
}
