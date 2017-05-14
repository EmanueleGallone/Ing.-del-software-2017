package provaGab.cranio.resources.list;

import provaGab.cranio.resources.Resource;

public class Stone extends Resource {
	private static final int STONES = 2;

	public Stone(){
		this(STONES);
	}
	
	public Stone(int value){
		super(value);
		id = 1;
	}
	

}
