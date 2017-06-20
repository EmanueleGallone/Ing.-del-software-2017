package it.polimi.ingsw.ps11.controller.server.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.network.rmi.RMIClientInterface;
import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.server.network.RemoteServer;

public interface RMIServerInterface extends RemoteServer {

	//Metodi che ha solo l'RMIServer

	public void setClient(RMIClientInterface client) throws RemoteException;
	public void receive(Message message) throws RemoteException;
}
