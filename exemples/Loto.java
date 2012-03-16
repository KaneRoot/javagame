import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Loto extends JFrame implements ActionListener
{
	JCheckBox[] tcases=new JCheckBox[49];
	JLabel lbl_cases_checked=new JLabel("Numéros cochés");
	JTextField jtf_nb_checked=new JTextField("0",5);
	JButton jb_valider=new JButton("Valider");

	JPanel jp_haut=new JPanel(new GridLayout(7,7));
	JPanel jp_nbcases=new JPanel();
	JPanel jp_bas=new JPanel(new BorderLayout());
	
	public Loto(String title)
	{
		super(title);
		for(int i=0;i<tcases.length;i++)
		{
			JCheckBox jchk=new JCheckBox(String.valueOf(i+1));
			jchk.addActionListener(this);
			tcases[i]=jchk;
			jp_haut.add(jchk);
		}
		this.add(jp_haut,BorderLayout.CENTER);
		jp_nbcases.add(lbl_cases_checked);
		jp_nbcases.add(jtf_nb_checked);
		jp_bas.add(jp_nbcases,BorderLayout.WEST);
		jb_valider.addActionListener(this);
		jb_valider.setEnabled(false);
		jp_bas.add(jb_valider,BorderLayout.EAST);
		this.add(jp_bas,BorderLayout.SOUTH);
	}
	public static void main(String[] args)
	{
		Loto loto=new Loto("Loto");
		loto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loto.pack();
		loto.setVisible(true);
	}
	private int getNbchecked()
	{
		int nb_cases=0;
		for(int i=0;i<this.tcases.length;i++)
		{
			if(tcases[i].isSelected())
			{
				nb_cases++;
			}
		}
		return nb_cases;
	}
	public void actionPerformed(ActionEvent e)
	{
		int nbr=this.getNbchecked();
		jtf_nb_checked.setText(String.valueOf(nbr));
		if(e.getSource()==jb_valider)
		{
			String text="";
			for(int i=0;i<this.tcases.length;i++)
			{
				if(this.tcases[i].isSelected())
				{
					text=text+tcases[i].getText()+" ";
				}
			}
			System.out.println(text);
		}
		else if(nbr==6)
		{
			jb_valider.setEnabled(true);
		}
		else
		{
			jb_valider.setEnabled(false);
		}
	}
}
