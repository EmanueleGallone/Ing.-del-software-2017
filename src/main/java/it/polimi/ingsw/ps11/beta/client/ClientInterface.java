package it.polimi.ingsw.ps11.beta.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.server.ServerInterface;
import it.polimi.ingsw.ps11.beta.server.rmi.RMIRemoteServer;

public interface ClientInterface extends Remote{

	// Method to call
	public void print(String message) throws RemoteException;

	//public void setRemoteServer(ServerInterface interface1);

}
