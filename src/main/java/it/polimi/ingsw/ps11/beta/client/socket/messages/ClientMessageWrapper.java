package it.polimi.ingsw.ps11.beta.client.socket.messages;

public class ClientMessageWrapper {

	private ClientMessage message;
	
	public ClientMessageWrapper(ClientMessage message) {
		this.message = message;
	}
	
	public ClientMessage getMessage() {
		return message;
	}
}
