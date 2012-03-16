package vue_modele;

import controleur.ControlerMap;

public class test
{

	public static void main (String[] arg)
	{
		E_perso e = new E_perso(10,200,10);
		Map m = new Map(1000,300,e);
		ControlerMap ctrl = new ControlerMap(m);
		ctrl.go();
	}
	
}
