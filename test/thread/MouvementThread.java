package thread;

import util.Vector2f;
import vue_modele.Map;

public class MouvementThread extends Thread
{
	private Map map_;
	private int type_; // Court=1 ,  Saute=2
	private Vector2f v_;
	
	public MouvementThread (Map m, int t, Vector2f v)
	{
		map_ = m;
		type_ = t;
		v_ = v;
	}
	
	public void run()
	{
		if (type_==1)
			notifierCourse();
		else if (type_==2)
			notifierSaut();
	}

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
	
	public void notifierCourse()
	{
		for (int i=0;i<10;i++)
		{
			try 
			{
				sleep(50);		
				map_.getPerso().setX((int)(map_.getPerso().getX()+v_.getI()));
				map_.getPerso().setY(map_.getYSol(map_.getPerso().getX()));
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
