package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import controleur.ControlerMap;
import modele.event.*;
import modele.Map;
import util.Vector2f;
import util.Point2d;


@SuppressWarnings("serial")
public class Vue extends VueMap implements KeyListener
{
	
	private int x,y;
	private Point2d window; // position x de la fenetre ( Initialement à 0 )	
	private int marge;
	
	public Vue(ControlerMap ctrl, int _x, int _y) 
	{
		super(ctrl);
		x = _x;
		y = _y;
		window = new Point2d();
		marge = 50;	
		this.addKeyListener(this);
	}


	public void paint(Graphics g)
        {
		// --------------------------
		// Dessin de l'arrière plan
       		g.setColor(new Color(20,20,20));
                g.fillRect(0, 0, 800, 300);
                
		// --------------------------
		// Calcul de la position de la fenetre
		if (getControler().getMap().getPerso().getPosition().getX()+marge > (this.getWidth() + window.getX()) 
							&& getControler().getMap().getPerso().getDx().getI()>0)	
			window.setX( window.getX() + getControler().getMap().getPerso().getPosition().getX()+marge - (this.getWidth() + window.getX()));
		else if (getControler().getMap().getPerso().getPosition().getX()-marge < (window.getX() + 10) && (window.getX() > 0)
                                                        && getControler().getMap().getPerso().getDx().getI()<0)  
		 	window.setX( window.getX() + (int) getControler().getMap().getPerso().getDx().getI());
	/*	
		if (getControler().getMap().getPerso().getPosition().getY()+marge > (this.getHeight() + window.getY())
                                                        && getControler().getMap().getPerso().getDx().getJ()>0)
                        window.setY( window.getY() + getControler().getMap().getPerso().getPosition().getY()+marge - (this.getHeight() + window.getY()));
                else if (getControler().getMap().getPerso().getPosition().getY()-marge < (window.getY() + 10)
							&& getControler().getMap().getPerso().getDx().getJ()<0)
                        window.setY( window.getY() + (int) getControler().getMap().getPerso().getDx().getJ());
	*/
	        // --------------------------
                // Dessin du perso
		g.setColor(new Color(240,0,0));
               	g.fillRect(x, y-getControler().getMap().getPerso().getSize(),
                         	        getControler().getMap().getPerso().getSize(),
                               		getControler().getMap().getPerso().getSize());
	
		// -------------------------
		// Dessin du sol
                g.setColor(new Color(0,240,0));
                for (int i=0;i<getControler().getMap().nbPointSol()-1;i++)
              	{		
                 	g.drawLine(getControler().getMap().getPointSolI(i).getX()-(window.getX()),
					getControler().getMap().getPointSolI(i).getY()+(window.getY()),
					getControler().getMap().getPointSolI(i+1).getX()-(window.getX()),
					getControler().getMap().getPointSolI(i+1).getY()+(window.getY()));		
                }

         }

	public void enMouvement(MouvementEvent event)
	{
		if (event != null)
		{
			x = (int) event.getVector().getI()-(window.getX()) ;
			y = (int) event.getVector().getJ()-(window.getY());
		}
		this.repaint();
	}

	public void keyPressed(KeyEvent arg0) 
	{
	
		if (arg0.getKeyChar() == 'd' || arg0.getKeyChar() == '6' )
			getControler().notifierMouvement(new Vector2f(1,0));
		else if (arg0.getKeyChar() == 'q' || arg0.getKeyChar() == '4' )
			getControler().notifierMouvement(new Vector2f(-1,0));
		else if (arg0.getKeyChar() == 'z' || arg0.getKeyChar() == '8')
			getControler().notifierMouvement(new Vector2f(0,20)); 
		else if (arg0.getKeyChar() == 'p' || arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
			getControler().getCtrlMenu().changerPanneau(new ChangementMenuEvent(this, ChangementMenuEvent.MENU_PRINCIPAL));

		System.out.print("x = "+x+"  y = "+--y+"\ndx/dt = ("+getControler().getMap().getPerso().getDx().getI()+","+
								getControler().getMap().getPerso().getDx().getJ()+")\n");
	}

	public void keyReleased(KeyEvent arg0) 
	{
		
	}

	public void keyTyped(KeyEvent arg0) 
	{
		
	}

}
