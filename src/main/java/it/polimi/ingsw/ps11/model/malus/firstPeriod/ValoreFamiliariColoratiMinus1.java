package it.polimi.ingsw.ps11.model.malus.firstPeriod;

import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;
import it.polimi.ingsw.ps11.model.malus.Excommunication;

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
