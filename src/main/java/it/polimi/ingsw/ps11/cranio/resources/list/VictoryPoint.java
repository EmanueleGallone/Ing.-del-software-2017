package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class VictoryPoint extends Resource{
	
	public VictoryPoint(){
		this(DEFAULT);
	}
	
	public VictoryPoint(int value){
		super(value);
	}
	
	private VictoryPoint(VictoryPoint toCopy){
		//copy Constructor
		super(toCopy.value);
	}

	@Override
	public VictoryPoint clone() {
		return new VictoryPoint(this);
	}
}
