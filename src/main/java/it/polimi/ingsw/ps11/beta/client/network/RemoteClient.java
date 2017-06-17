package it.polimi.ingsw.ps11.beta.client.network;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.ClientInterface;
import it.polimi.ingsw.ps11.beta.client.events.EndTurnEvent;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public abstract class RemoteClient implements ClientInterface {

	//Events that client can invoke
	protected EventHandler<EndTurnEvent> endTurnEvent = new EventHandler<>();
	
	protected RemoteClient() throws RemoteException {
		super();
	}
	
	public void endTurnEvent(EventListener<EndTurnEvent> listener) {
		endTurnEvent.attach(listener);
	}
	
}
