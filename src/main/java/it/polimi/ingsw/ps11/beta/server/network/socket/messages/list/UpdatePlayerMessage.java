package it.polimi.ingsw.ps11.beta.server.network.socket.messages.list;

import it.polimi.ingsw.ps11.beta.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.cranio.player.Player;

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
