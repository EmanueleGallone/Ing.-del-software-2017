package it.polimi.ingsw.ps11.beta.server.network.socket.messages.list;

import it.polimi.ingsw.ps11.beta.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.beta.server.network.socket.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

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
