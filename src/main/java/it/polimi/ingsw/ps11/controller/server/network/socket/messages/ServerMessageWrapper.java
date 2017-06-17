package it.polimi.ingsw.ps11.controller.server.network.socket.messages;

public class ServerMessageWrapper {

	private ServerMessage message;
	
	public ServerMessageWrapper(ServerMessage message) {
		this.message = message;
	}
	
	public ServerMessage getMessage() {
		return message;
	}
}
