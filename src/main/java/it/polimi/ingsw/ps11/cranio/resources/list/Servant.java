package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Servant extends Resource {

	public Servant(){
		this(DEFAULT);
	}
	
	public Servant(int value){
		super(value);
	}
	
	private Servant(Servant toCopy){
		super(toCopy.value);
	}

	@Override
	public Servant clone() {
		return new Servant(this);
	}
}
