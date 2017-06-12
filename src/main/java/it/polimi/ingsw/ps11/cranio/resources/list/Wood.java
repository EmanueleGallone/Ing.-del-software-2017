package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Wood extends Resource {

	public Wood(){
		this(DEFAULT);
	}
	
	public Wood(int value){
		super(value);
	}
	
	private Wood (Wood toCopy){
		super(toCopy.value);
	}
	
	@Override
	public Wood clone() {
		return new Wood(this);
	}

}
