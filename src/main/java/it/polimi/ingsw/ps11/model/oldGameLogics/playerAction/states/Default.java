package it.polimi.ingsw.ps11.model.oldGameLogics.playerAction.states;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.oldGameLogics.events.list.FloorSelected;
import it.polimi.ingsw.ps11.model.oldGameLogics.newAction.GameAction;
import it.polimi.ingsw.ps11.model.oldGameLogics.newAction.ScegliFamilyMember;
import it.polimi.ingsw.ps11.model.oldGameLogics.playerAction.PlayerStatus;
import it.polimi.ingsw.ps11.model.oldGameLogics.playerAction.State;

public class Default extends State {

	
	@Override
	public GameAction cheFaccio(FloorSelected event, PlayerStatus status) {
		return new ScegliFamilyMember();
	}

	@Override
	public GameAction cheFaccio(FamilyMember event, PlayerStatus playerStatus) {
		return null;
	}

}
