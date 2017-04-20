package it.polimi.ingsw.resources;

public class VictoryPoint extends Points{
	
	public VictoryPoint(){
		super();
	}
	
	public VictoryPoint(int value){
		super(value);
	}
	

	@Override
	public String toString() {
		return "VictoryPoint [value=" + value + "]";
	}

}
