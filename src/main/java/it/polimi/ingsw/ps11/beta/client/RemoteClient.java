package it.polimi.ingsw.ps11.beta.client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.beta.server.events.EndTurnEvent;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public abstract class RemoteClient extends UnicastRemoteObject implements ClientInterface, Serializable {

	protected EventHandler<EndTurnEvent> endTurnEvent = new EventHandler<>();
	
	protected RemoteClient() throws RemoteException {
		super();
	}
	
	public void endTurnEvent(EventListener<EndTurnEvent> listener) {
		endTurnEvent.attach(listener);
	}
	
}
