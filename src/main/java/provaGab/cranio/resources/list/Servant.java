package provaGab.cranio.resources.list;

import provaGab.cranio.resources.Resource;

public class Servant extends Resource {
	private static final int SERVANTS = 3;
	
	public Servant(){
		this(SERVANTS);
	}
	
	public Servant(int value){
		super(value);
		id = 4;
	}

}
