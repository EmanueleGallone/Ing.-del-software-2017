package it.polimi.ingsw.ps11.model.cards.effects;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;

public interface Effect extends Serializable{

	public Action get(ActionManager aManager);
	public void attach(ActionManager aManager);
}
