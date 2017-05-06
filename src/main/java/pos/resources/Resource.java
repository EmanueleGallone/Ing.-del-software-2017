package pos.resources;

import pos.interfaceList.Incrementable;

public class Resource implements Incrementable {
	private static final int DEFAULT_VALUE = 0;
	private static final int MINIMUM_VALUE = 0;
	
	private Resources type;
	private int value;
	
//Start constructor
	
	public Resource(Resources type){
		this(type, DEFAULT_VALUE);
	}
	
	public Resource(Resources type, int value) {
		this.type = type;
		this.value = value;
	}	
	
//End constructor
//Start logics

	@Override
	public void increment(int value) {
		this.value += value;
		if (this.value < MINIMUM_VALUE)
			this.value = MINIMUM_VALUE;
	}
	
//End logics
//Start setters
	public void setValue(int value) {
		this.value = value;
	}

//End setters
//Start getters
	
	public Resources getType() {
		return type;
	}
	public int getValue() {
		return value;
	}
//End getters
}
