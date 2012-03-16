import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FenetreBoutonsListener extends JFrame implements ActionListener{
	private JButton bouton;
	private JButton bouton2;
		
	public FenetreBoutonsListener(){
		super();
		
		build();//On initialise notre fen�tre
	}
	
	private void build(){
		setTitle("Fen�tre qui affiche des boutons"); //On donne un titre � l'application
		setSize(320,240); //On donne une taille � notre fen�tre
		setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
		setResizable(true); //On permet le redimensionnement
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		bouton = new JButton("Cliquez ici !");
		bouton.addActionListener(this);
		panel.add(bouton);
				
		bouton2 = new JButton("Ou l� !");
		bouton2.addActionListener(this);
		panel.add(bouton2);
		
		return panel;
	}
	
	public static void main(String[] args) {
		//On cr�e une nouvelle instance de notre FenetreBoutons
		FenetreBoutonsListener fenetre = new FenetreBoutonsListener();
		fenetre.setVisible(true);//On la rend visible
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == bouton){
			System.out.println("Vous avez cliqu� ici.");
		} else if(source == bouton2){
			System.out.println("Vous avez cliqu� l�.");	
		}
	}
}
