package it.polimi.ingsw.ps11.beta.client.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.server.network.rmi.RMIServerInterface;

public interface RMIClientInterface extends Remote {

	//Metodi che ha solo l'RMIClient
	public void setRemoteServer(RMIServerInterface server) throws RemoteException;
	public void invokeEndTurnEvent() throws RemoteException;
}
