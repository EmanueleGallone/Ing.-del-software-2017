package it.polimi.ingsw.ps11.controller.server.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIReceiver;

public interface ConnectionServer extends Remote {

	//public void connect(RMIClientInterface client) throws RemoteException;

	void connect(RMIReceiver remoteServer) throws RemoteException;
}
