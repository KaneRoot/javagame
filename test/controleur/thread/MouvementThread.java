package controleur.thread;

import util.Vector2f;
import modele.Map;

public class MouvementThread extends Thread
{
	private Map map_;
	private boolean born;
	private boolean repose;
	private boolean fin;	


	public MouvementThread (Map m)
	{
		map_ = m;
		born = true;
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
	
	public synchronized void reprendre()
	{
		notify();	
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
		Vector2f v_ = map_.getPerso().getDx();
		while (!fin)
		{
			try
			{	
				if (!(((int)map_.getPerso().getDx().norme()) == 0) || !isOnSoil())
				{ 	
					x=(int)(map_.getPerso().getPosition().getX()+v_.getI());
					y=(map_.getPerso().getPosition().getY()-v_.getJ()>=map_.getYSol(x)||isUnderSoil()?map_.getYSol(x):
								(int)(map_.getPerso().getPosition().getY()-v_.getJ()));
					//yi = y-map_.getPerso().getPosition().getY(); A utiliser plus tard 
					map_.getPerso().setPosition(x,y);
					map_.getPerso().setDx(map_.getPerso().getDx().getI()*(isOnSoil()?.88f:.99f), // Ff supérieur lors du contact ac le sol 
								(!isOnSoil()?map_.getPerso().getDx().getJ()-1f:0f));	
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
