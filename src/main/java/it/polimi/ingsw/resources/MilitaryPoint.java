package it.polimi.ingsw.resources;

public class MilitaryPoint extends Points {
	
	public MilitaryPoint(){
		super();
	}
	
	public MilitaryPoint(int value){
		super(value);
	}

	@Override
	public String toString() {
		return "MilitaryPoint [value=" + value + "]";
	}
	

}
