package it.polimi.ingsw.ps11.beta.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.ClientInterface;
import it.polimi.ingsw.ps11.beta.client.rmi.RMIRemoteClient;

public interface ConnectionServer extends Remote  {

	public void connect(ClientInterface client) throws RemoteException;
}
