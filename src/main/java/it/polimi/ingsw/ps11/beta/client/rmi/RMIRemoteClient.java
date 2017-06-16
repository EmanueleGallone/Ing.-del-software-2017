package it.polimi.ingsw.ps11.beta.client.rmi;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.beta.server.events.EndTurnEvent;
import it.polimi.ingsw.ps11.beta.server.rmi.RMIRemoteServer;

public class RMIRemoteClient extends RemoteClient implements RMIClientInterface {

	
	private RMIRemoteServer server;
	
	public RMIRemoteClient() throws RemoteException {
		super();
	}

// Comandi inviati
	
	@Override
	public void print(String message) {
		//server.print(message);
	}
	
// Comandi ricevuti 
	/*
	@Override
	public void endTurn() throws RemoteException {
		this.endTurnEvent.invoke(new EndTurnEvent());
	}
	*/

	@Override
	public void setRemoteServer(RMIRemoteServer server) {
		this.server = server;
		System.out.println("Dajee");
	}
}
