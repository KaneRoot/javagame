package vue.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import modele.listener.JBMenuListener;

public class Menu extends VueMenu
{
	public JButton jb_partie = new JButton("Commencer");

	public Menu(ControleurMenu c)
	{
		super(c);

		this.jb_partie.addActionListener(new JBMenuListener(this));

		JLabel jl_titre = new JLabel("Bienvenue sur le jeu ! Il est cool, vraiment.");
		this.add(jl_titre,BorderLayout.NORTH);
		this.add(jb_partie,BorderLayout.SOUTH);

		this.add(jp_menu);
	}
}
