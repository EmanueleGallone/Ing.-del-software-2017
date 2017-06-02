package it.polimi.ingsw.ps11.cranio.malus.firstPeriod;

import it.polimi.ingsw.ps11.cranio.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class ValoreFamiliariColoratiMinus1 extends Excommunication{
	
	public ValoreFamiliariColoratiMinus1(Player player) {
		this.owner = player;
	}

	@Override
	public void behaviour() {
		owner.getFamilyManager().getFamilyMember(BlackFamilyMember.class).setModifier(-1);
		owner.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).setModifier(-1);
		owner.getFamilyManager().getFamilyMember(WhiteFamilyMember.class).setModifier(-1);
		
	}

}
