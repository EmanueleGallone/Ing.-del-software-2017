package it.polimi.ingsw.ps11.cranio.familyMember;


import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class FamilyMember implements Cloneable {
	private final int DEFAULT = 0;
	
	protected int value;
	protected boolean isUsed;
	protected Player owner; 
	protected int id;
	protected int modifier;
	
	public FamilyMember(Player player){
		value = DEFAULT;
		isUsed = false;
		owner = player;
		id = 0;
		modifier = 0;
	}
	
//start logics
	
	public void resetModifier(){
		this.modifier = 0; // Si dovrebbe usare una costante di defaul a cui ritornare 
	}
	
	
//end logics
	
	
	
	@Override
	public FamilyMember clone (){
		try {
			
			return (FamilyMember) super.clone();
			
		} catch (CloneNotSupportedException e) {
			System.err.println("Clone not supported!");
		}
		return null; 
	}
	
	public Player getOwner(){
		return this.owner; 
	}
	
	public int getID(){
		return this.id; 
	}

	
	public void setModifier(int value){
		this.modifier = value;
	}
	
	public void setIsUsed(boolean value){
		isUsed = value;
	}
	
	public boolean isUsed(){
		return isUsed;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
