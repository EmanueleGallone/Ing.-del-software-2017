package it.polimi.ingsw.ps11.beta.server.rmi;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.events.PrintEvent;
import it.polimi.ingsw.ps11.beta.client.rmi.RMIRemoteClient;
import it.polimi.ingsw.ps11.beta.server.RemoteServer;

public class RMIRemoteServer extends RemoteServer implements RMIServerInterface{

	private RMIRemoteClient client;

	public RMIRemoteServer() {

	}
	
// Comandi inviati 
	
	@Override
	public void endTurn(){
		//C'e da decidere cosa fare con l'eccezione, se propagarla o meno
		try {
			client.endTurn();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

// Comandi ricevuti 
	
	@Override
	public void print(String message) throws RemoteException {
		this.printEvent.invoke(new PrintEvent(message));
	}

	
}
