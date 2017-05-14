package provaGab.cranio.resources.list;

import provaGab.cranio.resources.Resource;

public class FaithPoint extends Resource {

	public FaithPoint() {
		this(DEFAULT);

	}
	
	public FaithPoint(int value){
		super(value);
		id = 6;
	}

}
