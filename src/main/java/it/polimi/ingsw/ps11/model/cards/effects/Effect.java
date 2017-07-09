package it.polimi.ingsw.ps11.model.cards.effects;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/**
 * <h3> Effect </h3>
 * <p> Effetto di una carta: può essere di tipo istantaneo o permanente.</p>
 * <p> Richiede: ActiionManager (actionmanager da modificare).</p>
 * @see ActionManager
 */
public interface Effect extends Serializable{

	public Action get(ActionManager aManager);
}
