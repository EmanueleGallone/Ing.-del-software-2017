package it.polimi.ingsw.ps11.controller.client.network.rmi;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.RemoteClient;
import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.server.network.rmi.RMIServerInterface;

public interface RMIClientInterface extends RemoteClient {

	//Metodi che ha solo l'RMIClient
	public void setRemoteServer(RMIServerInterface server) throws RemoteException;
	public void receive(Message message) throws RemoteException;
}
