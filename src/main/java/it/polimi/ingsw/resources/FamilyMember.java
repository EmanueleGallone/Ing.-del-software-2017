package it.polimi.ingsw.resources;

public abstract class FamilyMember extends Resource {
	private boolean isUsed;
	
	public FamilyMember(){
		super();
		isUsed = false;
	}
	
	public void setIsUsed(boolean value){
		isUsed = value;
	}
	
	public boolean IsUsed(){
		return isUsed;
	}

}