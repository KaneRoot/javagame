package vue_modele;

import javax.swing.JFrame;

import controleur.ControlerMap;

import evenement.MouvementListener;


@SuppressWarnings("serial")
public abstract class VueMap extends JFrame  implements MouvementListener
{
	private ControlerMap ctrl_;
	
	public VueMap (ControlerMap ctrl)
	{
		super();
		ctrl_ = ctrl;
	}

	public ControlerMap getControler()
	{
		return ctrl_;
	}
	
	
}
