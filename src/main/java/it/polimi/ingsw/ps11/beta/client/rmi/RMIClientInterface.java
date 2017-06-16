package it.polimi.ingsw.ps11.beta.client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.server.rmi.RMIRemoteServer;

public interface RMIClientInterface extends Remote {

	public void print(String message) throws RemoteException;
	public void setRemoteServer(RMIRemoteServer server) throws RemoteException;
}
