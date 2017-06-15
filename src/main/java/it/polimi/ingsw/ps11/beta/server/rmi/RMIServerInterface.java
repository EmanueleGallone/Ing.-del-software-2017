package it.polimi.ingsw.ps11.beta.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.rmi.RMIRemoteClient;

public interface RMIServerInterface extends Remote {
	
	public void print(String message) throws RemoteException;

}
