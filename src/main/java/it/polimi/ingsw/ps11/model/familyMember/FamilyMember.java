package it.polimi.ingsw.ps11.model.familyMember;

import java.io.Serializable;

public abstract class FamilyMember implements Serializable{
	
	private final int DEFAULT_MODIFIER = 0;
	private final int DEFAULT_VALUE = 0;
	
	protected int value; 
	protected int modifier;
	
	
	public FamilyMember(){
		value = DEFAULT_VALUE;
		modifier = DEFAULT_MODIFIER;
	}
	
//start logics
	
//end logics

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
	public abstract FamilyMember clone();
	
	@Override
	public String toString() {
		return "FamilyMember [value=" + value + ", modifier=" + modifier + "]";
	}
	
}
