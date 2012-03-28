package controleur.thread;

import util.Vector2f;
import modele.Map;

public class MouvementThread extends Thread
{
	private Map map_;
	private boolean running;
	private boolean pause;
	
	public MouvementThread (Map m)
	{
		map_ = m;
		running = false;
		pause = true; 			
	}
	
	public boolean isRunning()
	{
		return running;
	}

	public boolean isPause()
	{
		return pause;
	}
	public void run()
	{	
		pause = false;
		running = true;
		deplacement();
		running = false;
		pause = true;
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
		int x,y;	
		Vector2f v_ = map_.getPerso().getDx();
		while ( (!map_.getPerso().getDx().isZero() || !isOnSoil()) )
		{
			try
			{	
				x=(int)(map_.getPerso().getPosition().getX()+v_.getI());
				y=(map_.getPerso().getPosition().getY()-v_.getJ()>=map_.getYSol(x)||isUnderSoil()?map_.getYSol(x):
							(int)(map_.getPerso().getPosition().getY()-v_.getJ()));

				map_.getPerso().setPosition(x,y);
				map_.getPerso().setDx(map_.getPerso().getDx().getI(),
								(!isOnSoil()?map_.getPerso().getDx().getJ()-1f:0f));	
				sleep(50);
			
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	

	
}
