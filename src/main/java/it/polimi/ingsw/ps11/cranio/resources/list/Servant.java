package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Servant extends Resource {

	public static final String type = "Servant";
	
	public Servant(){
		this(DEFAULT);
	}
	
	public Servant(int value){
		super(value);
	}

}
