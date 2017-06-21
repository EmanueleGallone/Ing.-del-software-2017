package it.polimi.ingsw.ps11.controller.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.message.generic.Message;

public interface RMIReceiver extends Remote {

	public void receive(Message message) throws RemoteException;
	public void connect(RMIReceiver connection) throws RemoteException;
}
