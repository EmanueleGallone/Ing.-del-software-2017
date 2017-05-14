package provaGab.cranio.familyMember;

import provaGab.cranio.dices.OrangeDice;
import provaGab.cranio.player.Player;

public class OrangeFamilyMember extends FamilyMember {
	
	private int value;
	OrangeDice dice;
	public OrangeFamilyMember(Player player){
		super(player);
		id = 3;
	}

	@Override
	public String toString() {
		return "YellowFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}
	
	public void associate(OrangeDice dice){
		this.dice = dice;
	}
	
	@Override
	public void updateValue(){
		value = dice.getValue();
	}

}
