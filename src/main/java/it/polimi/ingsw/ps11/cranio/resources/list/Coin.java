package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Coin extends Resource {
	
	public static final String type = "Coin";
	
	public Coin(){
		this(DEFAULT);
	}
	
	public Coin(int value){
		super(value);
	}

}
