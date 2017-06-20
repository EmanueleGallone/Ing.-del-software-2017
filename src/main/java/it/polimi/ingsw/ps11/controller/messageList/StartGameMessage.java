package it.polimi.ingsw.ps11.controller.messageList;

import it.polimi.ingsw.ps11.controller.message.TextualMessage;
import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.message.MessageRecognizer;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class StartGameMessage implements Message{

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
	public void accept(MessageRecognizer recognizer) {
		recognizer.handle(this);
	}
}
