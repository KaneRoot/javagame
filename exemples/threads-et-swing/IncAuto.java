import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;

public class IncAuto extends JFrame
{
	private JButton btn_plus = new JButton("+");
	private JButton btn_moins = new JButton("-");
	private JTextField jtf_compteur = new JTextField("0",5);
	private JBEcouteurPlus ecouteurPlus;
	private JBEcouteurMoins ecouteurMoins;
	private Timer t;
	private boolean increment = true; // true = incrémentation ; false = décrémentation
	public IncAuto()
	{
		
		ecouteurPlus = new JBEcouteurPlus(this);
		ecouteurMoins = new JBEcouteurMoins(this);
		this.setLayout(new FlowLayout());

		btn_moins.addActionListener(ecouteurMoins);
		btn_plus.addActionListener(ecouteurPlus);

		this.add(btn_moins);
		this.add(jtf_compteur);
		this.add(btn_plus);
	}
	public void setIncrement(boolean inc)
	{
		this.increment = inc;
	}
	public boolean getIncrement()
	{
		return this.increment;
	}
	public void setTexte(String bla)
	{
		this.jtf_compteur.setText(bla);
	}
	public String getTexte()
	{
		return this.jtf_compteur.getText();
	}
	public static void main(String[] args)
	{
		JFrame blabla = new IncAuto();
		blabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blabla.pack();
		blabla.setVisible(true);
		
	}
	public void startTimer()
	{
		if(! t.isRunning())
		{
			t.start();
		}
		else
		{
			t.restart();
		}
	}
	public void stopTimer()
	{
		t.stop();
	}
	public boolean getTimerIsRunning()
	{
		return t.isRunning();
	}
}

class JBEcouteurPlus implements ActionListener
{
	private IncAuto iauto;
	public JBEcouteurPlus(IncAuto ia)
	{
		this.iauto = ia;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(!iauto.getIncrement())
		{
			iauto.setIncrement(true);
			if(iauto.getTimerIsRunning())
				iauto.stopTimer();
		}
		else
		{
			iauto.startTimer();
		}
	}
	
}

class JBEcouteurMoins implements ActionListener
{
	private IncAuto iauto;
	public JBEcouteurMoins(IncAuto ia)
	{
		this.iauto = ia;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(iauto.getIncrement())
		{
			iauto.setIncrement(false);
			if(iauto.getTimerIsRunning())
				iauto.stopTimer();
		}
		else
		{
			iauto.startTimer();
		}
	}	
}
class MonThread extends Thread
{
	private JTextField jtf_compteur;
	private IncAuto iauto;
	public MonThread(IncAuto ia)
	{
		this.iauto = ia;
	}
	@Override
	public void run()
	{
		Runnable incremente;
		boolean Incrementer = iauto.getIncrement();
		try
		{
			while(!this.interrupted())
			{
				Thread.sleep(1000);
				if(Incrementer)
				{
					incremente = new Runnable() {
						public void run()
						{
							iauto.setTexte("" + (Integer.parseInt(iauto.getTexte()) + 1));
						}};
				}
				else
				{	
					incremente = new Runnable() {
						public void run()
						{
							iauto.setTexte("" + (Integer.parseInt(iauto.getTexte()) - 1));
						}};
				}
				SwingUtilities.invokeLater(incremente);
			}
		}
		catch (InterruptedException ie)
		{
			System.out.println("Il y a eu un arrêt brutal de ce thread :) ");
		}
	}
}
