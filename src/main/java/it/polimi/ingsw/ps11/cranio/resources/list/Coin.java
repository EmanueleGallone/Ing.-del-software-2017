package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Coin extends Resource {
	private static final int COINS = 5;
	
	public Coin(){
		this(COINS);
	}
	
	public Coin(int value){
		super(value);
		id = 3;
	}

}
