package it.polimi.ingsw.ps11.cranio.malus.firstPeriod;

import it.polimi.ingsw.ps11.cranio.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.cranio.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.cranio.malus.Excommunication;

public class ValoreFamiliariColoratiMinus1 extends Excommunication{
	

	public ValoreFamiliariColoratiMinus1() {
		setPeriod(1);
	}

	@Override
	public void behaviour() {
		getOwner().getFamilyManager().getFamilyMember(BlackFamilyMember.class).setModifier(-1);
		getOwner().getFamilyManager().getFamilyMember(OrangeFamilyMember.class).setModifier(-1);
		getOwner().getFamilyManager().getFamilyMember(WhiteFamilyMember.class).setModifier(-1);
		
	}

}
