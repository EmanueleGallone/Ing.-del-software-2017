package it.polimi.ingsw.ps11.beta.client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.server.rmi.RMIServerInterface;

public interface RMIClientInterface extends Remote {

	//Metodi che ha solo l'RMIClient
	public void setRemoteServer(RMIServerInterface server) throws RemoteException;
	public void invokeEndTurnEvent() throws RemoteException;
}
