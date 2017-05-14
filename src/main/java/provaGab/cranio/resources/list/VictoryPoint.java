package provaGab.cranio.resources.list;

import provaGab.cranio.resources.Resource;

public class VictoryPoint extends Resource{
	
	public VictoryPoint(){
		this(DEFAULT);
	}
	
	public VictoryPoint(int value){
		super(value);
		id = 7;
	}

}
