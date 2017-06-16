package it.polimi.ingsw.ps11.beta.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{

	// Method that server can call on the client
	public void print(String message) throws RemoteException;

}
