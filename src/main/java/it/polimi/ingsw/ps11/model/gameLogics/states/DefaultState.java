package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.PlayerHandler;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.event.viewEvent.FloorSelectedEvent;

public class DefaultState extends State{


	public DefaultState(PlayerHandler playerHandler) {
		super(playerHandler);
	}
	
	@Override
	public void visit(FloorSelectedEvent floorSelectedEvent) {
		
		playerHandler.setState(new WaitFamilyMember(playerHandler));
	}

}
