import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener
{
	int quelMenu = 0;
	JPanel jp_menu = new JPanel(new BorderLayout());
	JPanel jp_partie = new JPanel();

	JButton jb_partie = new JButton("Commencer");
	JButton jb_retour = new JButton("Retour !!");

	public Menu(String title)
	{
		super(title);

		this.jb_partie.addActionListener(this);
		this.jb_retour.addActionListener(this);

		// JPanel jp_menu
		JLabel jl_titre = new JLabel("Bienvenue sur le jeu ! Il est cool, vraiment.");
		this.jp_menu.add(jl_titre,BorderLayout.NORTH);
		this.jp_menu.add(jb_partie,BorderLayout.SOUTH);

		// JPanel jp_partie
		this.jp_partie.add(jb_retour);

		this.add(jp_menu);
	}
	public void changerPanneau()
	{
		switch(this.quelMenu)
		{
			case 0 :
				this.remove(this.jp_menu);
				this.add(this.jp_partie);
				this.quelMenu = 1;
				break;
			default :
				this.remove(this.jp_partie);
				this.add(this.jp_menu);
				this.quelMenu = 0;
				break;
		}
		this.repaint();
		this.pack();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == jb_partie)
			System.out.println("Bouton partie");
		else
			System.out.println("Bouton retour");

		this.changerPanneau();
	}
	public static void main(String[] args)
	{
		System.out.println("Début");
		Menu menu = new Menu("Menu");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.pack();
		menu.setVisible(true);
	}
}
