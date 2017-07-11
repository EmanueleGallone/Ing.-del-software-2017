package it.polimi.ingsw.ps11.model.cards.effects;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/**
 * <h3> Effect </h3>
 * <p> Classe che rappresenta l'effetto di una carta: può essere di tipo istantaneo o permanente.</p>
 * @param  ActionManager (actionmanager da modificare).</p>
 * @see ActionManager
 */
public interface Effect extends Serializable{

	/**
	 * <h3> public Action get() </h3>
	 * <p> Attiva l'effetto della carta, gli attributi del metodo richiesti variano per tipo di Effect.</p>
	 * @see Effect
	 */	
	public Action get(ActionManager aManager);
}
