package thread;

import util.Vector2f;
import vue_modele.Map;

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
	
	
	public void run()
	{
		deplacement();
	}

	/* Obsolète 
	public void notifierSaut()
	{
		int y = map_.getPerso().getY();
		for (float f=0;f<Math.PI;f+=0.1)
		{
			try 
			{
				sleep(10);		
				map_.getPerso().setY((int)(y-v_.getJ()*Math.sin(f)));
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	*/
	
	public void deplacement()
	{
		map_.getPerso().setDx(v_);
		int x,y;
		while (!map_.getPerso().getDx().isZero())
		{
			try 
			{
				sleep(50);
				x=0;
				y=0;
				map_.getPerso.setPosition(x,y);
				map_.getPerso.setDx(map_.getPerso().getDx());
				/*
				map_.getPerso().setX((int)(map_.getPerso().getX()+v_.getI()));
				map_.getPerso().setY(map_.getYSol(map_.getPerso().getX()));
				*/
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
