package it.polimi.ingsw.ps11.beta.server.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConnectionServer extends Remote {

	//public void connect(RMIClientInterface client) throws RemoteException;

	void connect(RMIServerInterface remoteServer) throws RemoteException;
}
