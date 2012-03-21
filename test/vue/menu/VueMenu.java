package vue.menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Pour tous les différents panneaux de menu (options, choix map…)
 *
 */

public class VueMenu extends JPanel
{
	private ControleurMenu c;

	public VueMenu(ControleurMenu c)
	{
		super();
		this.c = c;
	}
	public ControleurMenu getControleur()
	{
		return this.c;
	}
}
