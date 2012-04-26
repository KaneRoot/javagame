package vue.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import modele.Map;
import modele.listener.*;
import controleur.ControleurMenu;
import util.*;

/**
 * Gère l'affichage du menu de sélection de la carte sur laquelle jouer.
 *
 */

public class MenuCartes extends VueMenu
{
	/** La liste des cartes générées. */
	private ArrayList<Map> maliste;

	/** Le répertoire qui contient les cartes. */
	private String rep_cartes;

	/** Le panneau avec les boutons de sélection de carte. */
	private JPanel jp_boutons;

	/**
	 * @param c : Controleur du Menu principal.
	 * @param s : Le répertoire cartes.
	 *
	 */
	public MenuCartes(ControleurMenu c, String s)
	{
		super(c);

		JLabel jl_titre = new JLabel("Voici le menu des cartes ! ");
		this.rep_cartes = s;
		this.maliste = new ListeMaps(s).getListe();

		this.setSize((this.maliste.size() / 2) * 500, (this.maliste.size() % 2) * 50);
		this.jp_boutons = new JPanel();
		this.setLayout(new BorderLayout());

		this.jp_boutons.setLayout(new GridLayout(2, 1 + (this.maliste.size() / 2)));


		JButton jb;

		for(Map m : this.maliste)
		{
			jb = new JButton(m.getNom());
			jb.addActionListener(new JBMapListener(this.getControleur(), this, m));
			jb.setSize(50,100);

			this.jp_boutons.add(jb);
		}

		this.add(jl_titre, BorderLayout.NORTH);
		this.add(jp_boutons, BorderLayout.SOUTH);
	}
}
