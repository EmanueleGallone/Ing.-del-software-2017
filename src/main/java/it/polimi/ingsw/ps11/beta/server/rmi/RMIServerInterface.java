package it.polimi.ingsw.ps11.beta.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.rmi.RMIClientInterface;

public interface RMIServerInterface extends Remote {

	//Metodi che ha solo l'RMIServer
	//public void connect(RMIClientInterface client) throws RemoteException;
	public void invokePrintEvent(String message) throws RemoteException;
	public void setClient(RMIClientInterface client) throws RemoteException;
}
