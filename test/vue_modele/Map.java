package vue_modele;

import javax.swing.event.EventListenerList;

import evenement.MouvementListener;
import util.Point2d;


public class Map
{
	private Point2d[] sol_;
	private int w_,h_;
	private E_perso stick_;
	
	private EventListenerList ecouteurs_;
	
	public Map (int w,int h, E_perso e)
	{
		setW(w);
		setH(h);
		setStick(e);
		ecouteurs_ = new EventListenerList();
	}
	
	
	public void ajouterEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.add(MouvementListener.class, ml);
	}
	
	public void enleverEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.remove(MouvementListener.class, ml);
	}
	

	public void addPoint(Point2d sol) 
	{
		/*
		Point2d tmp;
		for (int i=0;i<sol_.length-1;i++)
		{
			if (sol_[i].getX()<sol.getX() && sol_[i+1].getX()>sol.getX())
			{
				tmp = sol_[i+1];
				sol_[i+1] = sol; 
			}
			else if (sol_[i].getX()>sol.getX())
			{
				tmp = sol_[i+1];
				sol_[i+1] = sol_[i];
			}
		}
		*/
	}
	
	public Point2d getSol(int x) 
	{
		int i;
		for (i=0;i<sol_.length && sol_[i].getX()>x;i++);
		float r = (sol_[i].getX()-sol_[i+1].getX())/(sol_[i].getY()-sol_[i+1].getY());
		return new Point2d(x,(int)(r*x));
	}

	public void setW(int w)
	{
		this.w_ = w;
	}

	public int getW()
	{
		return w_;
	}

	public void setH(int h) 
	{
		this.h_ = h;
	}

	public int getH_()
	{
		return h_;
	}

	public void setStick(E_perso stick)
	{
		this.stick_ = stick;
	}

	public E_perso getStick()
	{
		return stick_;
	}
	
	
/*
	private void initSol()
	{
		
	}
*/	
}
