package it.polimi.ingsw.ps11.network.server.messages;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.network.server.ServerRecognizer;

public class UpdateGame extends ServerMessage<Game> {

	public UpdateGame(Game message) {
		super(message);
	}

	@Override
	public void accept(ServerRecognizer recognizer) {
		recognizer.execute(this);
	}

}
