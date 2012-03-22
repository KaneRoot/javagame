package controleur.thread;

import util.Vector2f;
import modele.Map;

public class MouvementThread extends Thread
{
	private Map map_;
//	private int type_; // Court=1 ,  Saute=2
	private Vector2f v_;
	
	public MouvementThread (Map m, Vector2f v)
	{
		map_ = m;
		v_ = v;
	}
	
	public void setVector(Vector2f v)
	{
		v_ = v;
	}
	
	public Vector2f getVector()
	{
		return v_;
	}	
	
	public void run()
	{
		deplacement();
	}
	
	private boolean isOnSoil()
	{
		return (map_.getPerso().getPosition().getY() == map_.getYSol(map_.getPerso().getPosition().getX()));
	}

	public void deplacement()
	{
		map_.getPerso().setDx(v_);
		int x,y;
		for(;;)
		{
			try
			{
				//System.out.print("Est dans la boucle !! \n");
				map_.getPerso().setDx(v_);
				if (!map_.getPerso().getDx().isZero())
				{
			
					sleep(50);
					/*
					x=0;
					y=0;
					map_.getPerso().setPosition(x,y);
					map_.getPerso().setDx(map_.getPerso().getDx());
					*/
					map_.getPerso().setPosition((int)(map_.getPerso().getPosition().getX()+v_.getI()),
									map_.getYSol(map_.getPerso().getPosition().getX()));
						
				}
				else
					interrupt();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
