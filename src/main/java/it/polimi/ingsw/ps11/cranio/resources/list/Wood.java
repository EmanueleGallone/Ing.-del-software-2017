package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Wood extends Resource {
	private static final int WOODS = 2;
	
	public Wood(){
		this(WOODS);
	}
	
	public Wood(int value){
		super(value);
		id = 2;
	}

}
