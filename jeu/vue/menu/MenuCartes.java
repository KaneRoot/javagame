package vue.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import modele.Map;
import modele.listener.*;
import controleur.ControleurMenu;
import util.*;

public class MenuCartes extends VueMenu
{
	private ArrayList<Map> maliste;
	private String rep_cartes;

	private JPanel jp_boutons;

	public MenuCartes(ControleurMenu c, String s)
	{
		super(c);

		JLabel jl_titre = new JLabel("Voici le menu des cartes ! ");
		this.rep_cartes = s;
		this.jp_boutons = new JPanel();
		this.jp_boutons.setLayout(new GridLayout(2,2));

		this.maliste = new ListeMaps(s).getListe();

		this.setLayout(new BorderLayout());

		JButton jb;

		for(Map m : this.maliste)
		{
			jb = new JButton(m.getNom());
			jb.addActionListener(new JBMapListener(this.getControleur(), this, m));

			this.jp_boutons.add(jb);
		}

		this.add(jl_titre, BorderLayout.NORTH);
		this.add(jp_boutons, BorderLayout.SOUTH);
	}
}
