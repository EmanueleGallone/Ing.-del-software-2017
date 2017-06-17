package it.polimi.ingsw.ps11.controller.server.network.socket.messageList;

import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.model.player.Player;

public class UpdatePlayerMessage extends ServerMessage{

	Player player;
	
	public UpdatePlayerMessage(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void accept(ServerRecognizer serverRecognizer) {
		serverRecognizer.execute(this);
	}

}
