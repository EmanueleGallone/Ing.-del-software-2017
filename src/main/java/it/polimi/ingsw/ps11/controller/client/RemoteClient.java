package it.polimi.ingsw.ps11.controller.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.message.Message;

public interface RemoteClient extends Remote {
	public void send(Message message) throws RemoteException;
}
