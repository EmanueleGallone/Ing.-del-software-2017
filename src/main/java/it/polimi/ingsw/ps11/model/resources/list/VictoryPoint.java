package it.polimi.ingsw.ps11.model.resources.list;

import it.polimi.ingsw.ps11.model.resources.Resource;

public class VictoryPoint extends Resource{
	
	public VictoryPoint(){
		this(DEFAULT);
	}
	
	public VictoryPoint(int value){
		super(value);
	}

	@Override
	public VictoryPoint clone() {
		return new VictoryPoint(this.value);
	}
}