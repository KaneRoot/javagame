package controleur;

public class ControleurMenu 
{
	public JPanel jp_menu;
	public JPanel jp_partie;
	public JFrame jf_jeu;

	public ControleurMenu()
	{
		this.jf_jeu = new JFrame();

	}

	public void changerPanneau(ChangementMenuEvent e)
	{
		this.remove(e.panneau_actuel);
		switch(e.num_menu)
		{
			case ChangementMenuEvent.PARTIE :
				this.add(this.jp_partie);
				break;
			case ChangementMenuEvent.MENU_PRINCIPAL :
				this.add(this.jp_menu);
			default :
				System.out.println("soucis au niveau du changement de menu");
				break;
		}
		this.jf_jeu.repaint();
		this.jf_jeu.pack();
	}
}
