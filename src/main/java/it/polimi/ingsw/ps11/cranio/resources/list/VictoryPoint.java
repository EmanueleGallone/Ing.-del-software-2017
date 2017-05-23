package it.polimi.ingsw.ps11.cranio.resources.list;

import it.polimi.ingsw.ps11.cranio.resources.Resource;

public class VictoryPoint extends Resource{
	
	public static final String type = "VictoryPoint";
	
	public VictoryPoint(){
		this(DEFAULT);
	}
	
	public VictoryPoint(int value){
		super(value);
	}

}
