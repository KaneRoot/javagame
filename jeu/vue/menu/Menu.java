package vue.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import modele.listener.*;
import controleur.ControleurMenu;

public class Menu extends VueMenu 
{
	public JButton jb_partie = new JButton("Nouvelle partie");
	public JButton jb_recommencer = new JButton("Continuer");
	public JButton jb_map = new JButton("Choix de la carte !");

	public Menu(ControleurMenu c)
	{
		super(c);

		jb_partie.addActionListener(new JBStartGameListener(this.getControleur(), this));
		jb_recommencer.addActionListener(new JBResumeListener(this.getControleur(), this));
		jb_map.addActionListener(new JBMapChoiceListener(this.getControleur(), this));

		JLabel jl_titre = new JLabel("POUR RAPPEL CE JEU EST TRÈS BIEN.");
		this.setLayout(new BorderLayout());
		this.add(jl_titre,BorderLayout.NORTH);
		this.add(jb_partie,BorderLayout.CENTER);
		this.add(jb_map, BorderLayout.EAST);
		this.add(jb_recommencer,BorderLayout.SOUTH);
	}
}
