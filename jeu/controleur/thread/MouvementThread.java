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
	private boolean collision_;	


	public MouvementThread (Map m)
	{
		map_ = m;
		born = true;
		suspendre_ = false;
		repose = false;
		fin = false; 
		collision_ = false;		
	}
	
	public boolean isPause(){return repose;}

	public boolean isNouveauNe(){return born;}

	public void finir(){fin = true;}
	
	private synchronized void pause() throws InterruptedException 
	{
		repose = true;
		wait();
	}
	
	public void suspendre(){suspendre_ = true;}
	
	public synchronized void reprendre()
	{
		notify();	
		if (suspendre_)
			suspendre_ = false;
	}

	public void collision(){collision_ = true;}
	
	public void run()
	{
		born = false;
		deplacement();
	}
	
	private boolean isOnSoil()
	{
		return (map_.getPerso().getPosition().getY() 
			== map_.getYSol(map_.getPerso().getPosition().getX()));
	}

	private boolean isUnderSoil()
	{
		return (map_.getPerso().getPosition().getY() 
			> map_.getYSol(map_.getPerso().getPosition().getX()));
	}
	
	public void deplacement()
	{
		int x,y,yi;	
		boolean b;
		Vector2f v_ = map_.getPerso().getDx();
		while (!fin)
		{	
			v_ = map_.getPerso().getDx();
			b = false;	
			try
			{
				if ((!(((int)map_.getPerso().getDx().norme()) == 0) || !isOnSoil()) && !suspendre_)
				{
					x = (int)(map_.getPerso().getPosition().getX()+v_.getI());
					y = (map_.getPerso().getPosition().getY()-v_.getJ()>=map_.getYSol(x)||isUnderSoil()?
						map_.getYSol(x):(int)(map_.getPerso().getPosition().getY()-v_.getJ()));
					//yi = y-map_.getPerso().getPosition().getY(); A utiliser plus tard
					map_.getPerso().setPosition(x,y);

					if (!collision_)
					{
						map_.getPerso().setDx(map_.getPerso().getDx().getI()*(isOnSoil()?.80f:.85f),
								(!isOnSoil()?(map_.getPerso().getDx().getJ()-1f)*0.95f:0f));
					}
					else
					{
						map_.getPerso().setDx(map_.getPerso().getDx().getI(),0f);
						collision_ = false;
					}
					sleep(25);
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
