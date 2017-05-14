package provaGab.cranio.resources.list;

import provaGab.cranio.resources.Resource;

public class Wood extends Resource {
	private static final int WOODS = 2;
	
	public Wood(){
		this(WOODS);
	}
	
	public Wood(int value){
		super(value);
		id = 2;
	}

}
