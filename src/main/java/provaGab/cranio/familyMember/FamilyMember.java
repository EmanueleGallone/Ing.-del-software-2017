package provaGab.cranio.familyMember;


import provaGab.cranio.dices.Dice;
import provaGab.cranio.player.Player;

public abstract class FamilyMember implements Cloneable {
	private final int DEFAULT = 0;
	
	protected int value;
	protected boolean isUsed;
	protected Player owner; 
	protected int id;
	protected Dice dice;
	
	public FamilyMember(Player player){
		value = DEFAULT;
		isUsed = false;
		owner = player;
		id = 0;
		dice = null;
	}
	
//start logics
	
	
	
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
	
	public void updateValue(){}
}
