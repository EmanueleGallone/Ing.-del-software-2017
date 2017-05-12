package it.polimi.ingsw.resources;

public abstract class Points extends Resource {
	
	public Points(){
		super();
	}
	
	public Points(int value){
		super(value);
	}
	
	@Override
	public abstract String toString();

}
