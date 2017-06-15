package it.polimi.ingsw.ps11.beta.client.rmi;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.beta.server.events.EndTurnEvent;
import it.polimi.ingsw.ps11.beta.server.rmi.RMIRemoteServer;

public class RMIRemoteClient extends RemoteClient implements RMIClientInterface {

	
	private RMIRemoteServer server;
	
	protected RMIRemoteClient() throws RemoteException {
		super();
	}

// Comandi inviati
	
	@Override
	public void print(String message) {
		//C'e da decidere cosa fare con l'eccezione, se propagarla o meno
		try {
			server.print(message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
// Comandi ricevuti 
	
	@Override
	public void endTurn() throws RemoteException {
		this.endTurnEvent.invoke(new EndTurnEvent());
	}
}
