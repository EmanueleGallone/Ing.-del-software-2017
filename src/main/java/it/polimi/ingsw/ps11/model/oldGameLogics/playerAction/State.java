package it.polimi.ingsw.ps11.model.oldGameLogics.playerAction;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.oldGameLogics.events.list.FloorSelected;
import it.polimi.ingsw.ps11.model.oldGameLogics.newAction.GameAction;

public abstract class State {

	public abstract GameAction cheFaccio(FloorSelected event, PlayerStatus playerStatus);
	public abstract GameAction cheFaccio(FamilyMember event, PlayerStatus playerStatus);
}
