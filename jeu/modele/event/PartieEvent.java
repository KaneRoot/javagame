package modele.event;

import java.util.EventObject;

public class PartieEvent extends EventObject
{
	public static int FIN = 0;
	public static int PERDU = 1;
	public static int GAGNE = 2;
	
	private int flag;

	public PartieEvent (Object source,int flg)
	{
		super (source);
		flag = flg;
	}

	public int getFlag ()
	{
		return flag;
	}
}
