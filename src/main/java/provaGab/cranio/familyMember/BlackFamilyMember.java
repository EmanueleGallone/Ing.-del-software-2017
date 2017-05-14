package provaGab.cranio.familyMember;

import provaGab.cranio.dices.BlackDice;
import provaGab.cranio.player.Player;

public class BlackFamilyMember extends FamilyMember {
		
	private int value = 0;			//per il test, comunque va bene settare di base a 0
	BlackDice dice;
	public BlackFamilyMember(Player player){
		super(player);
		id = 1;
	}
	
	@Override
	public String toString() {
		return "BlackFamilyMember [value=" + value + " isUsed="+ isUsed + "]";
	}
	
	public void associate(BlackDice dice){
		this.dice = dice;
	}
	
	@Override
	public void updateValue(){
		value = dice.getValue();
	}

}
