package vue_modele;

/** Import des différentes librairie **/
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
/** Import des différents packetage **/
import evenement.MouvementListener;
import util.Point2d;


public class Map
{
	private ArrayList<Point2d> sol_;
	//private int masse;   /* Pour le calcul du mouvement */
	private int w_,h_;
	private E_perso stick_;
	
	private EventListenerList ecouteurs_;
	
	public Map (int w,int h, E_perso e)
	{
		sol_ = new ArrayList<Point2d>(2);
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
		Point2d tmp = new Point2d(),tmp1;
		
		for (int i=0;i<sol_.size()-1;i++)
		{
			if (sol_.get(i).getX() < sol.getX()  && sol_.get(i+1).getX() > sol.getX())
			{
				i++;
				tmp = sol_.get(i);
				sol_.set(i,sol);
			}
			else if (sol_.get(i).getX()>=sol.getX())
			{
				tmp1 = sol_.get(i);
				sol_.set(i,tmp);
				tmp = tmp1;
			}
		}
		
	}
	
	public Point2d getSol(int x) 
	{
		int i;
		for (i=0;i<sol_.size() && sol_.get(i).getX()>x;i++);
		float r = (sol_.get(i).getX()-sol_.get(i+1).getX())/(sol_.get(i).getY()-sol_.get(i+1).getY());
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
