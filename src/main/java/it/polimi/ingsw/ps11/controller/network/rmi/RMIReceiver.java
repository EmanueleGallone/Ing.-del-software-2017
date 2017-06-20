package it.polimi.ingsw.ps11.controller.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.message.Message;

public interface RMIReceiver extends Remote {

	public void receive(Message message) throws RemoteException;
	public void setConnection(RMIReceiver connection) throws RemoteException;
}
