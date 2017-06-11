package it.polimi.ingsw.ps11.cranio.familyMember;


import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class FamilyMember implements Cloneable {
	
	private final int DEFAULT_MODIFIER = 0;
	private final int DEFAULT_VALUE = 0;
	protected int value;
	protected Player owner; 

	protected int modifier;
	
	public FamilyMember(Player player){
		owner = player;
		value = DEFAULT_VALUE;
		modifier = DEFAULT_MODIFIER;
	}
	
//start logics
	
//end logics
	
	public Player getOwner(){
		return this.owner; 
	}

	public int getValue(){
		return this.value + this.modifier;
	}

	public void setModifier(int value){
		this.modifier = value;
	}
	
	public void resetModifier(){
		modifier = DEFAULT_MODIFIER;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	@Override
	public FamilyMember clone() {
		try {
			return (FamilyMember) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "FamilyMember [value=" + value + ", modifier=" + modifier + "]";
	}
	
}
