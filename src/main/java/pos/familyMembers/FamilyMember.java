package pos.familyMembers;

import pos.dices.Dice;
import pos.players.Player;

public class FamilyMember {
	
	private final static int DEFAULT_MODIFIER = 0;
	private Player owner;
	private Dice dice;
	private Colors color;
	private int modifier;
	
	public FamilyMember(Player player, Colors color){
		this.owner = player;
		this.color = color;
		this.modifier = DEFAULT_MODIFIER;
		//this.dice = diceManager.getDice(color); Bisogna o passargli il dato, oppure avere un 
		//gestore di dadi a livello globale
	}
	
	public int getValue() {
		
		return dice.getValue() + this.getModifier();
	}
	
	public void resetModifier(){
		modifier = DEFAULT_MODIFIER;
	}
	public int getModifier() {
		return modifier;
	}
	
	public Colors getColor() {
		return color;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
}
