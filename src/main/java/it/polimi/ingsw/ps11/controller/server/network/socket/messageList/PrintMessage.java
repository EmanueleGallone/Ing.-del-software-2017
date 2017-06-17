package it.polimi.ingsw.ps11.controller.server.network.socket.messageList;

import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerMessage;
import it.polimi.ingsw.ps11.controller.server.network.socket.messages.ServerRecognizer;

public class PrintMessage extends ServerMessage{

	private String message;
	
	public PrintMessage(String message) {
		this.message = message;
	}
	
	public String getContent() {
		return message;
	}

	@Override
	public void accept(ServerRecognizer serverRecognizer) {
		serverRecognizer.execute(this);
	}
}
