package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;

public interface Effect extends Serializable{

	public Action<?> get(ActionManager aManager);
}
