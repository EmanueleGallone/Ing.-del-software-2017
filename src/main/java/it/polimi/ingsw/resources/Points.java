package it.polimi.ingsw.resources;

public abstract class Points {
	protected int value;
	
	public Points(){
		this.value = 0;
	}
	
	public Points(int value){
		this.value = value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	@Override
	public abstract String toString();

}
