package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.player.Player;

public interface Requirement extends Serializable {

	public boolean isSatisfied(Player player);
}
