package provaGab.cranio.bonus;

import provaGab.cranio.player.Player;

public class familyMemberValueModifier {
	
	
	public familyMemberValueModifier(Player owner, int value, int type) {
		owner.setFamilyMemberBonus(type ,value);
	}
	
}
