package it.polimi.ingsw.ps11.beta.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

	// Method to call
	public void endTurn() throws RemoteException;
	
}
