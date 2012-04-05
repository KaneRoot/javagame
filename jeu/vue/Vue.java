package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import controleur.ControlerMap;
import modele.event.*;
import modele.elements.*;
import modele.Map;
import util.Vector2f;
import util.Point2d;


@SuppressWarnings("serial")
public class Vue extends VueMap implements KeyListener
{
	
	private int x,y;
	private Point2d window; // position de la fenetre ( Initialement à (0,0) )	
	private int margeX, margeY;
	private Color elemColor;
	
	public Vue(ControlerMap ctrl, int _x, int _y) 
	{
		super(ctrl);
		x = _x;
		y = _y;
		window = new Point2d();
		margeX = 100;
		margeY = 150;	
		this.addKeyListener(this);

		/** Variable de test **/
		elemColor = new Color(240,240,0);
	}

	private void translateWindow()
	{
	        // --------------------------
                // Calcul de la position de la fenetre
		// --------------------------
		// --------------------------
                //// Axe des x
                if (getControler().getMap().getPerso().getPosition().getX()+margeX >= (this.getWidth() + window.getX()))
                        window.setX(window.getX() + getControler().getMap().getPerso().getPosition().getX() + margeX - (this.getWidth() + window.getX()));
                else if (getControler().getMap().getPerso().getPosition().getX() <= (window.getX() + margeX) && (window.getX() > 0))
                        window.setX(window.getX() - (margeX - (getControler().getMap().getPerso().getPosition().getX()-window.getX())));
		// --------------------------
		// --------------------------
                //// Axe des y  
                if (getControler().getMap().getPerso().getPosition().getY()-margeY <= (window.getY()))
                        window.setY(window.getY()-(margeY-(getControler().getMap().getPerso().getPosition().getY()-window.getY())));
                else if (getControler().getMap().getPerso().getPosition().getY() >= (window.getY() + (margeY+150)))
                        window.setY(window.getY() + (getControler().getMap().getPerso().getPosition().getY() - (window.getY() + (margeY+150))));
	}

	public void paint(Graphics g)
        {
		// --------------------------
		// Dessin de l'arrière plan
       		g.setColor(new Color(20,20,20));
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                
		// -------------------------
		// Dessin du sol
                g.setColor(new Color(0,240,0));
                for (int i=0;i<getControler().getMap().nbPointSol()-1;i++)
              	{		
                 	g.drawLine(getControler().getMap().getPointSolI(i).getX()-(window.getX()),
					getControler().getMap().getPointSolI(i).getY()-(window.getY()),
					getControler().getMap().getPointSolI(i+1).getX()-(window.getX()),
					getControler().getMap().getPointSolI(i+1).getY()-(window.getY()));		
                }

	        // --------------------------
                // Dessin du perso
		g.setColor(new Color(240,0,0));
               	g.fillRect(x, y-getControler().getMap().getPerso().getSize(),
                         	        getControler().getMap().getPerso().getSize(),
                               		getControler().getMap().getPerso().getSize());

		// --------------------------
		// Dessin des élements de la map
		g.setColor(elemColor);
		Element e;
		for (int i=0;i<getControler().getMap().nbElem();i++)
		{
			e = getControler().getMap().getElem(i);
			g.fillRect(e.getPosition().getX()-window.getX(),e.getPosition().getY()-window.getY(),
					e.getSize(), e.getSize());
		}

         }

	public void enMouvement(MouvementEvent event)
	{
		translateWindow();
		if (event != null)
		{
			x = (int) event.getVector().getI()-(window.getX());
			y = (int) event.getVector().getJ()-(window.getY());
		}
		this.repaint();
	}

	public void enCollision(CollisionEvent event)
	{
		elemColor = new Color(elemColor.getBlue(),elemColor.getRed(),elemColor.getGreen());
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
		{
			getControler().getCtrlMenu().changerPanneau(new ChangementMenuEvent(this, 
										ChangementMenuEvent.MENU_PRINCIPAL));
		}


//		System.out.print("x = "+x+"  y = "+--y+"\ndx/dt = ("+getControler().getMap().getPerso().getDx().getI()+","+
//								getControler().getMap().getPerso().getDx().getJ()+")\n");
	}

	public void keyReleased(KeyEvent arg0) 
	{
		
	}

	public void keyTyped(KeyEvent arg0) 
	{
		
	}

}
