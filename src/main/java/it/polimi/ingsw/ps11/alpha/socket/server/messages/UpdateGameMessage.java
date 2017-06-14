package it.polimi.ingsw.ps11.alpha.socket.server.messages;

import it.polimi.ingsw.ps11.alpha.socket.server.ServerRecognizer;
import it.polimi.ingsw.ps11.cranio.game.Game;

public class UpdateGameMessage extends ServerMessage<Game> {

	public UpdateGameMessage(Game message) {
		super(message);
	}

	@Override
	public void accept(ServerRecognizer recognizer) {
		recognizer.execute(this);
	}

}
