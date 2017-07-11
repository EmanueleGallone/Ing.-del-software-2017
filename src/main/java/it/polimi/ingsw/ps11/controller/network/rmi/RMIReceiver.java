package it.polimi.ingsw.ps11.controller.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.network.message.Message;
/**
 * <h3> Client </h3>
 * <p> Interfaccia per la gestione dei messaggi a lato Client di tipo RMI.</p>
 * @see Remote
 */
public interface RMIReceiver extends Remote {

	public void receive(Message message) throws RemoteException;
	public void connect(RMIReceiver connection) throws RemoteException;
}
