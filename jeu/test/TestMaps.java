package test;

import java.io.*;
import java.util.ArrayList;

import modele.Map;
import util.ChargementMap;
import util.ListeMaps;

public class TestMaps
{
	public static void main(String[] args)
	{
		//ChargementMap c = new ChargementMap(args[0]);
		ListeMaps lesmaps = new ListeMaps("./maps");
		ArrayList<Map> ml = lesmaps.getListe();
		for(Map m : ml)
			System.out.println("Le nom de la map : " + m.getNom());
	}
}
