package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class MilitaryPoint extends Resource {
	
	public MilitaryPoint(){
		this(DEFAULT);
	}
	
	public MilitaryPoint(int value){
		super(value);
	}

	@Override
	protected MilitaryPoint clone() {
		return new MilitaryPoint(value);
	}
}
