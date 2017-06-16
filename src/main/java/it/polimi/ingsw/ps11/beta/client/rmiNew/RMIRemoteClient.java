package it.polimi.ingsw.ps11.beta.client.rmiNew;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.beta.server.events.EndTurnEvent;
import it.polimi.ingsw.ps11.beta.server.rmiNew.RMIServerInterface;

public class RMIRemoteClient extends RemoteClient implements RMIClientInterface, Serializable {

	private RMIServerInterface server;
	
	public RMIRemoteClient() throws RemoteException {
		super();
	}

	@Override
	public void print(String message){
		try {
			
			server.invokePrintEvent(message);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setRemoteServer(RMIServerInterface server) throws RemoteException {
		this.server = server;
		System.out.println("ok settato");
	}

	@Override
	public void invokeEndTurnEvent() throws RemoteException {
		this.endTurnEvent.invoke(new EndTurnEvent());
	}

}
