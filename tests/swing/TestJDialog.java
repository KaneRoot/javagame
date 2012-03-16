import javax.swing.*;

public class TestJDialog 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				JDialog dialog = new JDialog();		//On crée une nouvelle instance de notre JDialog

				dialog.setSize(300, 200);								// On lui donne une taille
				dialog.setTitle("Première fenêtre");					// On lui donne un titre
				dialog.setVisible(true);								// On la rend visible
				dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// On dit à l'application de se fermer lors du clic sur la croix
			}
		});
	}
}

