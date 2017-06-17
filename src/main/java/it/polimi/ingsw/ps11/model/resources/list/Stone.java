package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;

public class Stone extends Resource {
	
	public Stone(){
		this(DEFAULT);
	}
	
	public Stone(int value){
		super(value);
	}
	

	@Override
	public Stone clone() {
		return new Stone(this.value);
	}
}