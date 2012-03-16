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
		
		build();//On initialise notre fenêtre
	}
	
	private void build(){
		setTitle("Fenêtre qui affiche des boutons"); //On donne un titre à l'application
		setSize(320,240); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On permet le redimensionnement
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		bouton = new JButton("Cliquez ici !");
		bouton.addActionListener(this);
		panel.add(bouton);
				
		bouton2 = new JButton("Ou là !");
		bouton2.addActionListener(this);
		panel.add(bouton2);
		
		return panel;
	}
	
	public static void main(String[] args) {
		//On crée une nouvelle instance de notre FenetreBoutons
		FenetreBoutonsListener fenetre = new FenetreBoutonsListener();
		fenetre.setVisible(true);//On la rend visible
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == bouton){
			System.out.println("Vous avez cliqué ici.");
		} else if(source == bouton2){
			System.out.println("Vous avez cliqué là.");	
		}
	}
}
