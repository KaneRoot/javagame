package controleur;

import modele.event.ChangementMenuEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import vue.menu.Menu;

public class ControleurMenu 
{
	public JPanel jp_menu;
	public JPanel jp_partie;
	public JFrame jf_jeu;

	public ControleurMenu()
	{
		this.jf_jeu = new JFrame();
		this.jp_menu = new Menu(this);
	}

	public void go()
	{
		this.jf_jeu.add(jp_menu);
		this.jf_jeu.pack();
	}
	public void changerPanneau(ChangementMenuEvent e)
	{
		this.jf_jeu.remove(e.panneau_actuel);
		switch(e.num_menu)
		{
			case ChangementMenuEvent.PARTIE :
				this.jf_jeu.add(this.jp_partie);
				break;
			case ChangementMenuEvent.MENU_PRINCIPAL :
				this.jf_jeu.add(this.jp_menu);
			default :
				System.out.println("soucis au niveau du changement de menu");
				break;
		}
		this.jf_jeu.repaint();
		this.jf_jeu.pack();
	}
}
