package test;

import controleur.*;
import modele.*;
import modele.event.*;
import modele.listener.*;
import vue.*;
import vue.menu.*;


/**
 * Actuellement la classe principale
 *
 */
public class TestMenu
{
	public static void main(String[] args)
	{
		ControleurMenu c = new ControleurMenu();
		c.go();
	}
}
