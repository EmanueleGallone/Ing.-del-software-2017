package pos.Resources;

import pos.dices.Dice;
import pos.players.Player;

public class FamilyMember extends Resource{
	
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
	
	@Override
	public int getValue() {
		return dice.getValue();
	}
	
	public Player getOwner() {
		return owner;
	}
}
