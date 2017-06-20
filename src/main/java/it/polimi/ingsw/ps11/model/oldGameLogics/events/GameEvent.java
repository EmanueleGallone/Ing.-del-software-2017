package it.polimi.ingsw.ps11.model.oldGameLogics.events;

import it.polimi.ingsw.ps11.model.oldGameLogics.GameLogic;

public interface GameEvent {

	public void accept(GameLogic gameLogic);
}
