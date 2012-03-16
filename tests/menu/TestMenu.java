package test;

import menu;

import javax.swing.JFrame;

public class TestMenu
{
	public static void main(String[] args)
	{
		System.out.println("Début");
		Menu menu = new Menu("Menu");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.pack();
		menu.setVisible(true);
	}
}
