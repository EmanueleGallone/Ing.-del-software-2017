package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Stone extends Resource {

	public static final String type = "Stone";
	
	public Stone(){
		this(DEFAULT);
	}
	
	public Stone(int value){
		super(value);
	}
	

}
