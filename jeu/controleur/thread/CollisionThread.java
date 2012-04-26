package controleur.thread;

import modele.Map;

public class CollisionThread extends Thread
{
	private Map map_;
	private MouvementThread thread_;
	private boolean fin;
	
	public CollisionThread (Map map, MouvementThread thread)
	{
		map_ = map;
		thread_ = thread;
		fin = false;
	}

	public void run ()
	{
		boolean b;
		while (!fin)
		{
			/**
			*	On test tout les objets de la map qui pourrait 
			*	entrer en collision
			**/
			b=false;
			for (int i=0;i<map_.nbElem()&&!b;i++)
			{
				b = map_.getElem(i).entreEnCollision(map_.getPerso());
			}
			if (b)
			{
				thread_.collision();
			}
			try
			{
				sleep (50);
			}
			catch (InterruptedException e)
			{
				// TODO Execption interruption
			}
		}
	}
}
