package pos.familyMembers;

import pos.dices.Dice;
import pos.players.Player;

public class FamilyMember{
	
	private Player owner;
	private Dice dice;
	
	
	public FamilyMember(Player player){
		super();
		this.owner = player;
	}
	
	public FamilyMember(Player player,Dice dice) {
		this(player);
		this.dice = dice;
	}
	
	public int getValue() {
		return dice.getValue();
	}
	
	public Player getOwner() {
		return owner;
	}
}
