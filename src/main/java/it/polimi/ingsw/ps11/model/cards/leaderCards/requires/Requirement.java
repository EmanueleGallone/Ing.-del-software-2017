package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3> CardNumberRequirement </h3>
 * <p> Classe che rappresenta i requisiti di attivazione di una carta leader.</p>
 */
public interface Requirement extends Serializable {

	public boolean isSatisfied(Player player);
}
