package vue.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import modele.listener.*;
import controleur.ControleurMenu;

public class Menu extends VueMenu
{
	public JButton jb_partie = new JButton("Commencer");
	public JButton jb_recommencer = new JButton("Recommencer");

	public Menu(ControleurMenu c)
	{
		super(c);

		this.jb_partie.addActionListener(new JBStartGameListener(this.getControleur(), this));
		this.jb_recommencer.addActionListener(new JBResumeListener(this.getControleur(), this));

		JLabel jl_titre = new JLabel("Bienvenue sur le jeu ! Il est cool, vraiment.");
		this.add(jl_titre,BorderLayout.NORTH);
		this.add(jb_partie,BorderLayout.SOUTH);
		this.add(jb_recommencer,BorderLayout.SOUTH);
	}
}
