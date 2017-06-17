package it.polimi.ingsw.ps11.controller.server.masterServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

	// Method that client can call on the server
	public void endTurn() throws RemoteException;
	
}
