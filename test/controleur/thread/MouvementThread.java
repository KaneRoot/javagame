package controleur.thread;

import util.Vector2f;
import modele.Map;

public class MouvementThread extends Thread
{
	private Map map_;
	private boolean born;
	private boolean repose;
	private boolean suspendre_;
	private boolean fin;	


	public MouvementThread (Map m)
	{
		map_ = m;
		born = true;
		suspendre_ = false;
		repose = false;
		fin = false; 			
	}
	
	public boolean isPause()
	{
		return repose;
	}

	public boolean isNouveauNe()
	{
		return born;
	}

	public void finir()
	{
		fin = true;
	}
	
	public synchronized void pause() throws InterruptedException 
	{
		System.out.print("PAUSE\n\n");
		repose = true;
		wait();
	}
	
	public void suspendre()
	{
		suspendre_ = true;
	}	
	
	public synchronized void reprendre()
	{
		notify();	
		if (suspendre_)
			suspendre_ = false;
	}
	
	public void run()
	{
		born = false;
		deplacement();
	}
	
	private boolean isOnSoil()
	{
		return (map_.getPerso().getPosition().getY() == map_.getYSol(map_.getPerso().getPosition().getX()));
	}

	private boolean isUnderSoil()
	{
		return (map_.getPerso().getPosition().getY() > map_.getYSol(map_.getPerso().getPosition().getX()));
	}
	
	public void deplacement()
	{
		int x,y,yi;	
		boolean b;
		Vector2f v_ = map_.getPerso().getDx();
		while (!fin)
		{	
			b = false;	
			try
			{	
				if ((!(((int)map_.getPerso().getDx().norme()) == 0) || !isOnSoil()) && !suspendre_)
				{ 	
					for (int i=0;i<map_.nbElem()&&!b;i++)  // Premier test, un peu barbare
						b = map_.getPerso().entreEnCollision(map_.getElem(i));
					//if (!b)
					//{
						x = (int)(map_.getPerso().getPosition().getX()+v_.getI());
						y = (map_.getPerso().getPosition().getY()-v_.getJ()>=map_.getYSol(x)||isUnderSoil()?map_.getYSol(x):
									(int)(map_.getPerso().getPosition().getY()-v_.getJ()));
						//yi = y-map_.getPerso().getPosition().getY(); A utiliser plus tard 
						map_.getPerso().setPosition(x,y);
						map_.getPerso().setDx(map_.getPerso().getDx().getI()*(isOnSoil()?.88f:.99f),
									(!isOnSoil()?(map_.getPerso().getDx().getJ()-1f)*0.99f:0f));
					//}
					
					sleep(50);
				}
				else
					pause();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}	
}
