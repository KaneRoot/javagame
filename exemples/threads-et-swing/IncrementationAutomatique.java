import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;

public class IncrementationAutomatique extends JFrame
{
	private JButton btn_plus = new JButton("+");
	private JButton btn_moins = new JButton("-");
	private JTextField jtf_compteur = new JTextField("0",5);
	private JBEcouteurPlus ecouteurPlus;
	private JBEcouteurMoins ecouteurMoins;
	private MonThread t;
	private boolean increment = true; // true = incrémentation ; false = décrémentation
	public IncrementationAutomatique()
	{
		t = new MonThread(this);
		ecouteurPlus = new JBEcouteurPlus(this,t);
		ecouteurMoins = new JBEcouteurMoins(this,t);
		this.setLayout(new FlowLayout());

		btn_moins.addActionListener(ecouteurMoins);
		btn_plus.addActionListener(ecouteurPlus);

		this.add(btn_moins);
		this.add(jtf_compteur);
		this.add(btn_plus);
		this.jtf_compteur.setForeground(new Color(0,0,0));
		
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
		JFrame blabla = new IncrementationAutomatique();
		blabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blabla.pack();
		blabla.setVisible(true);
		
	}
	public void startThread()
	{
		if(t.getState() == Thread.State.NEW || t.getState() == Thread.State.TERMINATED)
		{
			t = new MonThread(this);
			t.start();
		}
	}
	public void stopThread()
	{
		t.interrupt();
	}
	public Thread.State getThreadState()
	{
		return t.getState();
	}
}

class JBEcouteurPlus implements ActionListener
{
	private IncrementationAutomatique iauto;
	private MonThread t;
	public JBEcouteurPlus(IncrementationAutomatique ia,MonThread thread)
	{
		this.iauto = ia;
		this.t = thread;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(!iauto.getIncrement())
		{
			iauto.setIncrement(true);
			if(iauto.getThreadState() != Thread.State.TERMINATED && iauto.getThreadState() != Thread.State.NEW)
				iauto.stopThread();
		}
		else
		{
			iauto.startThread();
		}
	}
	
}

class JBEcouteurMoins implements ActionListener
{
	private IncrementationAutomatique iauto;
	private MonThread t;
	public JBEcouteurMoins(IncrementationAutomatique ia,MonThread thread)
	{
		this.iauto = ia;
		this.t = thread;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(iauto.getIncrement())
		{
			iauto.setIncrement(false);
			if(iauto.getThreadState() != Thread.State.TERMINATED && iauto.getThreadState() != Thread.State.NEW)
				iauto.stopThread();
		}
		else
		{
			iauto.startThread();
		}
	}	
}
class MonThread extends Thread
{
	private JTextField jtf_compteur;
	private IncrementationAutomatique iauto;
	public MonThread(IncrementationAutomatique ia)
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
