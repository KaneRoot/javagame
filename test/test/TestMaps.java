package test;

import java.io.*;
import util.ChargementMap;

public class TestMaps
{
	private static void printContent (File file, int level)
	{
		for (File f : file.listFiles())
		{
			for (int i = 0; i < level; i++) System.out.print ("|\t");

			if (f.isDirectory())
			{
				System.out.println ("+ " + f.getName());
				printContent (f, level + 1);
			}
			else
			{
				System.out.println ("| " + f.getName());
			}
		}
	}
	public static void main(String[] args)
	{
		//ChargementMap c = new ChargementMap(args[0]);
		File f = new File("./maps");
		TestMaps.printContent(f, 0);
	}
}
