package it.polimi.ingsw.ps11.model.oldGameLogics.playerAction;

import it.polimi.ingsw.ps11.model.oldGameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.oldGameLogics.GameLogics;
import it.polimi.ingsw.ps11.model.oldGameLogics.events.GameEvent;
import it.polimi.ingsw.ps11.model.oldGameLogics.events.list.FloorSelected;
import it.polimi.ingsw.ps11.model.oldGameLogics.newAction.GameAction;
import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerStatus extends GameLogics implements GameLogic {

	private State status;
	private Player player;
	
	public void gestisci(GameEvent event){
		event.accept(this);
	}
	
	
	@Override
	public void handle() {
		
	}

	public void setStatus(State status) {
		this.status = status;
	}

	@Override
	public void handle(FloorSelected floorSelected) {
		GameAction action = status.cheFaccio(floorSelected,this);
		action.perform(this);
	}
}
