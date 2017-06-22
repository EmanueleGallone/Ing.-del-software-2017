package it.polimi.ingsw.ps11.model.gameLogics.actions.networkAction;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;

public class SendAction implements Action {

	private Connection client;
	private TextualMessage message;
	
	public SendAction(Connection client, TextualMessage message) {
		this.client = client;
		this.message = message;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		//client.send(message);
	}

}
