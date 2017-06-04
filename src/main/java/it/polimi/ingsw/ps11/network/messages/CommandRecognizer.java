package it.polimi.ingsw.ps11.network.messages;

import it.polimi.ingsw.ps11.cranio.player.Player;

public interface CommandRecognizer {

	public void execute(DefaultCommand command);
	public void execute(Player player);
}
