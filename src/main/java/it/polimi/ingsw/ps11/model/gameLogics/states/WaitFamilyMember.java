package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.PlayerStatus;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.view.viewEvents.FloorSelectedEvent;

public class WaitFamilyMember extends State{

	public WaitFamilyMember(PlayerStatus playerHandler) {
		super(playerHandler);
	}

	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		// TODO Auto-generated method stub
		
	}

}
