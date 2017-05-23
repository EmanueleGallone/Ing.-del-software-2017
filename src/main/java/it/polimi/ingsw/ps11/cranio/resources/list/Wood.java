package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Wood extends Resource {

	public static final String type = "Wood";
	
	public Wood(){
		this(DEFAULT);
	}
	
	public Wood(int value){
		super(value);
	}

}
