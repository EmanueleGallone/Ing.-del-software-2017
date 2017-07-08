package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import it.polimi.ingsw.ps11.model.player.Player;

public interface Requirement {

	public boolean isSatisfied(Player player);
}
