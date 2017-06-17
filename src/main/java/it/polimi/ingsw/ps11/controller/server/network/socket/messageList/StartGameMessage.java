package it.polimi.ingsw.ps11.controller.server.network.socket.messageList;

import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class StartGameMessage extends ServerMessage{

	private Game game;
	private Player player;
	
	public StartGameMessage(Game game , Player player) {
		this.game = game;
		this.player = player;
	}
	
	public Game getGame() {
		return game;
	}
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void accept(ServerRecognizer serverRecognizer) {
		serverRecognizer.execute(this);
	}

}
