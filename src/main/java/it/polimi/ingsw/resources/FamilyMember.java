package it.polimi.ingsw.resources;

public abstract class FamilyMember extends Resource {
	private boolean isUsed;
	
	public FamilyMember(){
		super();
		isUsed = false;
	}
	
	public void setIsUsed(boolean value){
		this.isUsed = value;
	}
	
	public boolean IsUsed(){
		return this.isUsed;
	}

}
