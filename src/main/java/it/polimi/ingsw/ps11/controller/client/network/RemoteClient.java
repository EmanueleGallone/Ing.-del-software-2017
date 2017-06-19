package it.polimi.ingsw.ps11.controller.client.network;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.ClientInterface;
import it.polimi.ingsw.ps11.controller.client.events.EndTurnEvent;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public abstract class RemoteClient implements ClientInterface {

	//Events that client can invoke
	protected EventHandler<EndTurnEvent> endTurnEvent = new EventHandler<>();
	
	protected RemoteClient() throws RemoteException {
		super();
	}
	
	public void endTurnEvent(EventListener<EndTurnEvent> listener) {
		endTurnEvent.attach(listener);
	}
	
	/*
	 * Vorrei fare in modo che qualsiasi evento venga invocato, il gameController lo passa 
	 * al gameLogics e quest'ultimo tramite il pattern Visitor seleziona il listener che andrà
	 * a creare ed eseguire l'azione corretta
	 */
	
}
