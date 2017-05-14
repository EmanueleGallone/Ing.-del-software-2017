package provaGab.cranio.resources.list;

import provaGab.cranio.resources.Resource;

public class MilitaryPoint extends Resource {
	
	public MilitaryPoint(){
		this(DEFAULT);
	}
	
	public MilitaryPoint(int value){
		super(value);
		id = 5;
	}

}
