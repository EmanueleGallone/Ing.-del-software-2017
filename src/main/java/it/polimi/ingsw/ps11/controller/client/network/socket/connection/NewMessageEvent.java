package it.polimi.ingsw.ps11.controller.client.network.socket.connection;

public class NewMessageEvent {

	private String message;
	
	public NewMessageEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
