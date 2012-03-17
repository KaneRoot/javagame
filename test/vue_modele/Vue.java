package vue_modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;

import controleur.ControlerMap;

import evenement.MouvementEvent;

import util.Vector2f;


@SuppressWarnings("serial")
public class Vue extends VueMap implements KeyListener
{
	private JPanel panel = null;
	private int x,y;
	
	public Vue(ControlerMap ctrl, int _x, int _y) 
	{
		super(ctrl);
		x = _x;
		y = _y;
		
		panel = new JPanel()
		{
			public void paint(Graphics g)
			{
				g.setColor(new Color(20,20,20));
				g.fillRect(0, 0, 800, 300);
				g.setColor(new Color(200,0,0));
				g.fillRect(x, y-getControler().getMap().getPerso().getSize(), 
								getControler().getMap().getPerso().getSize(), 
								getControler().getMap().getPerso().getSize());
				
				g.setColor(new Color(0,200,0));
				for (int i=0;i<getControler().getMap().nbPointSol()-1;i++)
				{
					g.drawLine(getControler().getMap().getPointSolI(i).getX(), 
								getControler().getMap().getPointSolI(i).getY(), 
								getControler().getMap().getPointSolI(i+1).getX(), 
								getControler().getMap().getPointSolI(i+1).getY());
				}
				
			}
		};
		
		this.addKeyListener(this);
		setContentPane(panel);
		pack();
		this.setSize(800,300);
	}


	public void enMouvement(MouvementEvent event)
	{
		x = (int) event.getVector().getI();
		y = (int) event.getVector().getJ();
		panel.repaint();
	}

	public void keyPressed(KeyEvent arg0) 
	{
		if (arg0.getKeyChar() == 'd' || arg0.getKeyChar() == '6' )
			getControler().notifierMouvement(new Vector2f(1,0));
		else if (arg0.getKeyChar() == 'q' || arg0.getKeyChar() == '4' )
			getControler().notifierMouvement(new Vector2f(-1,0));
		else if (arg0.getKeyChar() == 'z' || arg0.getKeyChar() == '8')
			getControler().notifierSaut(new Vector2f(0,50)); 
		System.out.print("x = "+x+"  y = "+y+"\n");
	}

	public void keyReleased(KeyEvent arg0) 
	{
		
	}

	public void keyTyped(KeyEvent arg0) 
	{
		
	}

}
