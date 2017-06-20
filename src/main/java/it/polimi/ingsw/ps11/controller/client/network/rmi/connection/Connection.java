package it.polimi.ingsw.ps11.controller.client.network.rmi.connection;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public abstract class Connection {

	EventHandler<MessageEvent> messageArrived = new EventHandler<>();
	
	public abstract void send(Message message);
	
	public void attachMessageListener(EventListener<MessageEvent> listener){
		messageArrived.attach(listener);
	}
}
