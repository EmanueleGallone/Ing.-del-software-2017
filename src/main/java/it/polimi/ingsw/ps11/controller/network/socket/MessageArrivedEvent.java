package it.polimi.ingsw.ps11.controller.network.socket;

import it.polimi.ingsw.ps11.controller.message.Message;

public class MessageArrivedEvent {

	private Message message;
	
	public MessageArrivedEvent(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
	
}
