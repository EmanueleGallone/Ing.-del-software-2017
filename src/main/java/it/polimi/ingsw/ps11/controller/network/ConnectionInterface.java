package it.polimi.ingsw.ps11.controller.network;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.message.MessageArrivedEvent;
import it.polimi.ingsw.ps11.controller.message.generic.Message;
import it.polimi.ingsw.ps11.model.events.EventListener;

public interface ConnectionInterface {

	public void on() throws IOException;
	public void send(Message message) throws IOException;
	public void attachMessageListener(EventListener<MessageArrivedEvent> listener);
	
}