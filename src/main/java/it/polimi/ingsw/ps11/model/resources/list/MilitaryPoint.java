package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;

public class MilitaryPoint extends Resource {
	
	public MilitaryPoint(){
		this(DEFAULT);
	}
	
	public MilitaryPoint(int value){
		super(value);
	}

	@Override
	public MilitaryPoint clone() {
		return new MilitaryPoint(this.value);
	}
}