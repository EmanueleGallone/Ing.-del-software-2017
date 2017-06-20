package it.polimi.ingsw.ps11.controller.messageList.toClient;

import it.polimi.ingsw.ps11.controller.message.ClientMessage;
import it.polimi.ingsw.ps11.controller.message.ClientMessageRecognizer;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class StartGameMessage implements ClientMessage{

	private Game game;
	private Player player;
	
	public StartGameMessage(Game game, Player player) {
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
	public void accept(ClientMessageRecognizer recognizer) {
		recognizer.handle(this);
	}
}
