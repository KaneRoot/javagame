package modele;

/** Import des différentes librairie **/
import java.util.ArrayList;
import javax.swing.event.EventListenerList;
/** Import des différents packetage **/
import modele.listener.MouvementListener;
import util.Point2d;
import modele.elements.*;

public class Map
{
	private ArrayList<Point2d> sol_;
	private ArrayList<Element> elem_;

	private int masse;   	/* Pour le calcul du mouvement */
	private int w_,h_; 	/* w_ indique la largeur et h_ indique la hauteur */
	private int arrivee; // Arrivée
	private E_perso perso_;
	private EventListenerList ecouteurs_;
	private String nom = null;

	/**
	 * Ce constructeur va servir pour faire une copie de la Map courante.
	 *
	 */
	public Map(int w, int h, int masse, E_perso e, ArrayList<Point2d> sol, ArrayList<Element> elements, String nom, EventListenerList ecouteurs)
	{
		setW(w);
		setH(h);
		setPerso(e);
		setNom(nom);
		setSol(sol);
		setEcouteurs(ecouteurs);
	}
	
	public Map (int w,int h, E_perso e)
	{
		elem_ = new ArrayList<Element>(1);
		sol_ = new ArrayList<Point2d>(2);
		setW(w);
		setH(h);
		setPerso(e);
		ecouteurs_ = new EventListenerList();
	}

	public Map()
	{
		this(0,0,null);
	}
	
	public void setSol(ArrayList<Point2d> sol) { this.sol_ = sol; }
	public void setEcouteurs(EventListenerList ecouteurs) { this.ecouteurs_ = ecouteurs; }
	public void setArrivee(int a) { this.arrivee = a; }
	public void setNom(String lenom) { this.nom = lenom; }
	public String getNom() { return this.nom; }
	public int getArrivee() { return this.arrivee; }

	public void ajouterEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.add(MouvementListener.class, ml);
	}
	
	public void enleverEcouteurMouvement (MouvementListener ml)
	{
		ecouteurs_.remove(MouvementListener.class, ml);
	}

	public void addElem(Element e) { elem_.add(e); }

	public int nbElem()	{ return elem_.size(); }

	public Element getElem(int i) { return elem_.get(i); }

	public void addPoint(Point2d sol) { sol_.add(sol); }
	
	public int nbPointSol() { return sol_.size(); }
	
	public Point2d getPointSolI(int i) { return sol_.get(i); }
	
	public int getYSol(int x) 
	{
		int i;
		for (i=0;! (sol_.get(i).getX() < x && sol_.get(i+1).getX() >= x) && 
				i < sol_.size()-2 ; i++);
		float r = (float)(sol_.get(i+1).getY()-sol_.get(i).getY())
			/ (float)(sol_.get(i+1).getX()-sol_.get(i).getX());

		return (int)(r*(x-sol_.get(i).getX()) + sol_.get(i).getY());
	}

	public void setW(int w) { this.w_ = w; }

	public int getW() { return w_; }

	public void setH(int h) { this.h_ = h; }

	public int getH() { return h_; }

	public void setPerso(E_perso stick) { this.perso_ = stick; }

	public E_perso getPerso() { return perso_; }

	public void setMasse(int masse) { this.masse = masse; }

	public int getMasse() { return masse; }

	public Map copie()
	{
		ArrayList<Element> nouveaux_elements = new ArrayList<Element>(10);
		ArrayList<Point2d> nouveau_sol = new ArrayList<Point2d>(10);

		// quand on saura faire : ajouter une copie des éléments
		for(Element e : this.elem_)
			nouveaux_elements.add(e);
		
		// idem
		for(Point2d p : this.sol_)
			nouveau_sol.add(p);

		return new Map(getW(), getH(), getMasse(), getPerso(), nouveau_sol, nouveaux_elements, getNom(), this.ecouteurs_);
	}

}
