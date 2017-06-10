package it.polimi.ingsw.ps11.cranio.zones.actionSpace.pos;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class FamilyMemberSlot {
	
	private Player player;
	private FamilyMember familyMember;
	
	public FamilyMemberSlot(Player player , FamilyMember familyMember) {
		this.player = player;
		this.familyMember = familyMember;
	}
	
	public Player getPlayer() {
		return player;
	}
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
}
