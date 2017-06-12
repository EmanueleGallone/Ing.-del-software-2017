package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class Stone extends Resource {

	public Stone(){
		this(DEFAULT);
	}
	
	public Stone(int value){
		super(value);
	}
	
	private Stone(Stone toCopy){
		super(toCopy.value);
	}
	

	@Override
	public Stone clone() {
		return new Stone(this);
	}
}
