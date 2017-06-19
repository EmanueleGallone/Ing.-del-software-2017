package it.polimi.ingsw.ps11.model.gameLogics.events;

import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;

public interface Event {

	public void accept(GameLogic gameLogic);
}
