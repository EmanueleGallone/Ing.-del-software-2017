package it.polimi.ingsw.ps11.beta.server.rmiNew;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.rmiNew.RMIClientInterface;

public interface ConnectionServer extends Remote {

	public void connect(RMIClientInterface client) throws RemoteException;
}
