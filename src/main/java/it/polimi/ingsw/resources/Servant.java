package it.polimi.ingsw.resources;

public class Servant extends Resource {
	
	public Servant(){
		super();
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int value) {
		this.value=value;
	}

	@Override
	public String toString() {
		return "Servant [value=" + value + "]";
	}
	
	

}
