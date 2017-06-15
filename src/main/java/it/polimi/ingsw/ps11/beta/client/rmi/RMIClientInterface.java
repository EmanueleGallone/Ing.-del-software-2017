package it.polimi.ingsw.ps11.beta.client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClientInterface extends Remote {

	public void endTurn() throws RemoteException;
}
