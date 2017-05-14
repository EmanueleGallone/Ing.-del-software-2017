package provaGab.cranio.familyMember;

import provaGab.cranio.dices.WhiteDice;
import provaGab.cranio.player.Player;

public class WhiteFamilyMember extends FamilyMember {

	private int value;
	WhiteDice dice;
	public WhiteFamilyMember(Player player){
		super(player);
		id = 2;
	}

	@Override
	public String toString() {
		return "WhiteFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}
	
	public void associate(WhiteDice dice){
		this.dice = dice;
	}
	
	@Override
	public void updateValue(){
		value = dice.getValue();
	}

}
