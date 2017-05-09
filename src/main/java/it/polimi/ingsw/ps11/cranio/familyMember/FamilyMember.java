package it.polimi.ingsw.ps11.cranio.familyMember;


import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class FamilyMember implements Cloneable {
	private final int DEFAULT = 0;
	
	protected int value;
	protected boolean isUsed;
	protected Player owner; 
	
	public FamilyMember(Player player){
		value = DEFAULT;
		isUsed = false;
		owner = player;
	}
	
	public FamilyMember(){
		super();
		isUsed = false;
	}
	
	/**
	 * public void setIsUsed(boolean value) 
	 * setter per la variabile isUsed
	 * @param value - boolean 
	 */
	public void setIsUsed(boolean value){
		isUsed = value;
	}
	
	/**
	 *  public boolean isUsed()
	 * se il familiare è stato usato ritorna true 
	 * @return boolean 
	 */
	public boolean isUsed(){
		return isUsed;
	}
	public int getValue(){
		return this.value;
	}
	public void setValue(int value){
		this.value = value;
	}
	
	
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

}
