package it.polimi.ingsw.ps11.startSetup;

import java.util.HashMap;

public class Prova1 {

	private Prova2 prova2 = new Prova2();
	HashMap<Class<? extends Integer>, Prova2> map = new HashMap<>();
	
	//HashMap<Integer>, Prova2> map = new HashMap<>();
	
	public Prova1() {
	/*
	  	map.put(0, new Prova2());

		map.put(1, new Prova2());

		map.put(2, new Prova2());
	*/
		
		map.put(new Integer(0).getClass(), new Prova2());

		map.put(new Integer(1).getClass(), new Prova2());

		map.put(new Integer(2).getClass(), new Prova2());
	}
}
