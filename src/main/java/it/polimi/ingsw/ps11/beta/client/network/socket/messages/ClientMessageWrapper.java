package it.polimi.ingsw.ps11.beta.client.network.socket.messages;

public class ClientMessageWrapper {

	private ClientMessage message;
	
	public ClientMessageWrapper(ClientMessage message) {
		this.message = message;
	}
	
	public ClientMessage getMessage() {
		return message;
	}
}
