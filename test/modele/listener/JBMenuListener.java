package modele.listener;

import vue.menu.Menu;

public class JBMenuListener implements ActionListener
{
	Menu m;

	public JBMenuListener(Menu m)
	{
		this.m = m;
	}
	public void actionPerformed(ActionEvent e)
	{
		this.m.changerPanneau();
	}
}
