package test;

import vue_modele.*;
import vue_modele.elements.*;

import util.Point2d;
import controleur.ControlerMap;

public class Test
{
	public static void main (String[] arg)
	{
		E_perso e = new E_perso(10,200,10);
		Map m = new Map(1000,300,e);
		
		m.addPoint(new Point2d(0,250));
		m.addPoint(new Point2d(200,200));
		m.addPoint(new Point2d(400,250));
		m.addPoint(new Point2d(600,200));
		m.addPoint(new Point2d(800,250));
		m.getPerso().setY(m.getYSol(m.getPerso().getX()));
		
		ControlerMap ctrl = new ControlerMap(m);
		ctrl.go();
	}
	
}
