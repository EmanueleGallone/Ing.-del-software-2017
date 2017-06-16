package it.polimi.ingsw.ps11.beta.server.rmiNew;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.events.PrintEvent;
import it.polimi.ingsw.ps11.beta.client.rmiNew.RMIClientInterface;
import it.polimi.ingsw.ps11.beta.server.RemoteServer;

public class RMIRemoteServer extends RemoteServer implements RMIServerInterface, Serializable{

	private RMIClientInterface client;
	
	public RMIRemoteServer(RMIClientInterface client) {
		this.client = client;
	}
	
	@Override
	public void endTurn(){
		try {
			
			client.invokeEndTurnEvent();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void invokePrintEvent(String message) throws RemoteException {
		this.printEvent.invoke(new PrintEvent(message));
		System.out.println("Dajeeeeeee");
	}

}
