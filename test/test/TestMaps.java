package test;

import java.io.*;
import util.ChargementMap;

public class TestMaps
{
	public static void main(String[] args)
	{
		//ChargementMap c = new ChargementMap(args[0]);
		File f = new File("./maps");
		TestMaps.printContent(f, 0);
	}
}
