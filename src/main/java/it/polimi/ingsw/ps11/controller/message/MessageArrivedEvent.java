package it.polimi.ingsw.ps11.controller.message;

import it.polimi.ingsw.ps11.controller.message.generic.Message;

public class MessageArrivedEvent {

	private Message message;
	
	public MessageArrivedEvent(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
	
}
