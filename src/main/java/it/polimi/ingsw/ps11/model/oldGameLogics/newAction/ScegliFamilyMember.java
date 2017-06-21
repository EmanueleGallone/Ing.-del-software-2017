package it.polimi.ingsw.ps11.model.oldGameLogics.newAction;

import it.polimi.ingsw.ps11.model.oldGameLogics.playerAction.PlayerStatus;

public class ScegliFamilyMember extends GameAction {

	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform(PlayerStatus status) {
		//Invia un messaggio al giocatore "Scegli familyMember"
	}


}
