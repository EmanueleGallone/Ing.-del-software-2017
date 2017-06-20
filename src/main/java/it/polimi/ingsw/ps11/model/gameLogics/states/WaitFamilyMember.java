package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.PlayerHandler;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.event.viewEvent.FloorSelectedEvent;

public class WaitFamilyMember extends State{

	public WaitFamilyMember(PlayerHandler playerHandler) {
		super(playerHandler);
	}

	@Override
	public void visit(FloorSelectedEvent floorSelectedEvent) {
		
	}

}
