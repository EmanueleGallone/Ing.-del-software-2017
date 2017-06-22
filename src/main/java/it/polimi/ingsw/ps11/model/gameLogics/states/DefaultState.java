package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.PlayerStatus;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.FloorSelectedEvent;

public class DefaultState extends PlayerStatus implements State{


	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		//playerStatus.setState(new WaitFamilyMember(playerStatus));
	}

	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		
	}
}
