package it.polimi.ingsw.resources;

public abstract class Resource {
	protected int value;
	
	public Resource(){
		//initialized value for any type of resource
		this.value=0;
	}
	
	public abstract int getValue();
	public abstract void setValue(int value);  //scomodo per i FamilyMember. non lo uso. devo capire cosa inventarmi. ema
	public abstract String toString();

}
