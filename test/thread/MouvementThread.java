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
		for (float f=0;f<Math.PI;f+=0.01)
		{
			try 
			{
				sleep(10);		
				map_.getStick().setY((int)(map_.getStick().getY()-v_.getJ()*Math.sin(f)));
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
				map_.getStick().setX((int)(map_.getStick().getX()+v_.getI()));
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
