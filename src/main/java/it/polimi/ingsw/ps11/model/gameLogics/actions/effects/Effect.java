package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;

public interface Effect {

	public Action get(ActionManager aManager);
}
