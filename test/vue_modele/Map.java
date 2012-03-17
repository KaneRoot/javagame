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
	private int masse;   	/* Pour le calcul du mouvement */
	private int w_,h_; 		/* w_ indique la largeur et h_ indique la hauteur */
	private E_perso perso_;
	private EventListenerList ecouteurs_;
	
	public Map (int w,int h, E_perso e)
	{
		sol_ = new ArrayList<Point2d>(2);
		setW(w);
		setH(h);
		setPerso(e);
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
		sol_.add(sol);
	}
	
	public int nbPointSol()
	{
		return sol_.size();
	}
	
	public Point2d getPointSolI(int i)
	{
		return sol_.get(i);
	}
	
	public int getYSol(int x) 
	{
		int i;
		for (i=0;!(sol_.get(i).getX()<x&&sol_.get(i+1).getX()>x) && i<sol_.size()-2;i++);
		float r = (float)(sol_.get(i+1).getY()-sol_.get(i).getY())/(float)(sol_.get(i+1).getX()-sol_.get(i).getX());
		return (int)(r*(x-sol_.get(i).getX())+sol_.get(i).getY());
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

	public void setPerso(E_perso stik)
	{
		this.perso_ = stik;
	}

	public E_perso getPerso()
	{
		return perso_;
	}

	public void setMasse(int masse)
	{
		this.masse = masse;
	}

	public int getMasse()
	{
		return masse;
	}

}
