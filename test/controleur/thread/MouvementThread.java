package controleur.thread;

import util.Vector2f;
import modele.Map;

public class MouvementThread extends Thread
{
	private Map map_;
	
	public MouvementThread (Map m)
	{
		map_ = m;
	}
	
	public void run()
	{
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
	
	public synchronized void deplacement()
	{
		int x,y;
		for(;;)
		{
			Vector2f v_ = map_.getPerso().getDx();
			try
			{
				if (!map_.getPerso().getDx().isZero() || !isOnSoil())
				{
			
					sleep(50);
					
					x=(int)(map_.getPerso().getPosition().getX()+v_.getI());
					y=(map_.getPerso().getPosition().getY()-v_.getJ()>=map_.getYSol(x)||isUnderSoil()?map_.getYSol(x):
								(int)(map_.getPerso().getPosition().getY()-v_.getJ()));

					map_.getPerso().setPosition(x,y);
					map_.getPerso().setDx(map_.getPerso().getDx().getI(),
									(!isOnSoil()?map_.getPerso().getDx().getJ()-1f:0f));	
				}
				else
					sleep(100); // TRES MOCHE -- VOUE A DISPARAITRE DANS UN AVENIR  PROCHE !!
				
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	

	
}
