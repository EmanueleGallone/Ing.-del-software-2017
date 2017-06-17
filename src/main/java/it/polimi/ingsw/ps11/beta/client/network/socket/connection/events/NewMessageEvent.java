package it.polimi.ingsw.ps11.beta.client.network.socket.connection.events;

public class NewMessageEvent {

	private String message;
	
	public NewMessageEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
