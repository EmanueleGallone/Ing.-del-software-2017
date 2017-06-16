package it.polimi.ingsw.ps11.beta.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{

	// Method to call
	public void print(String message) throws RemoteException;

	//public void setRemoteServer(ServerInterface interface1);

}
