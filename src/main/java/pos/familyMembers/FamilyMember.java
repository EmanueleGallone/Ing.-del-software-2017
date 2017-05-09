package pos.familyMembers;

import pos.dices.Dice;
import pos.events.EventHandler;
import pos.players.Player;

public class FamilyMember {
	
	private final static int DEFAULT_MODIFIER = 0;
	private Player owner;
	private Dice dice;
	private int modifier;
	
	public FamilyMember(Player player, Dice dice){
		this.owner = player;
		this.dice = dice;
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
		return dice.getColors();
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
}
