package controleur.thread;

import modele.Map;
import modele.elements.Element;

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
		int i;
		while (!fin)
		{
			/**
			*	On test tout les objets de la map qui pourrait 
			*	entrer en collision
			**/
			b=false;
			for (i=0;i<map_.nbElem()&&!b;i++)
			{
				b = map_.getElem(i).entreEnCollision(map_.getPerso());
			}
			if (b && (map_.getElem(i-1).getEtat()!=Element.ATTRAPABLE &&
						map_.getElem(i-1).getEtat()!=Element.ATTRAPER))
			{
			//	thread_.collision(true);
			}
			else	
			{
				thread_.collision(false);
			}
			try
			{
				sleep (12);
			}
			catch (InterruptedException e)
			{
				// TODO Execption interruption
			}
		}
	}
}
