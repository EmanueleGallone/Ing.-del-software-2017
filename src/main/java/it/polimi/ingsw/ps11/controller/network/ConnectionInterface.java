package it.polimi.ingsw.ps11.controller.network;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.message.MessageEvent;
import it.polimi.ingsw.ps11.model.events.EventListener;

public interface ConnectionInterface {

	public void on() throws IOException;
	public void send(Message message) throws IOException;
	public void attachListener(EventListener<MessageEvent> listener);
	public void detachListener(EventListener<MessageEvent> listener);
	
}
