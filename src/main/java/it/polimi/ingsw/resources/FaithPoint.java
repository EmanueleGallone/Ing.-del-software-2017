package it.polimi.ingsw.resources;

public class FaithPoint extends Points {
	
	public FaithPoint(){
		super();
	}
	
	public FaithPoint(int value){
		super(value);
	}

	@Override
	public String toString() {
		return "FaithPoint [value=" + value + "]";
	}

}
