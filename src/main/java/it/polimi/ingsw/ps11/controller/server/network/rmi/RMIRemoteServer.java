package it.polimi.ingsw.ps11.controller.server.network.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.network.rmi.RMIClientInterface;
import it.polimi.ingsw.ps11.controller.message.Message;

public class RMIRemoteServer implements RMIServerInterface, Serializable{

	private RMIClientInterface client;
	
	public RMIRemoteServer() {
	}
	
	public RMIRemoteServer(RMIClientInterface client) {
		this.client = client;
	}

	@Override
	public void send(Message message) throws RemoteException {
		client.receive(message);
	}

	@Override
	public void setClient(RMIClientInterface client) throws RemoteException {
		this.client = client;
	}

	@Override
	public void receive(Message message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
/*
// Metodi che il client puo' chiamare sul server
	
	@Override
	public void endTurn(){
		try {
			
			client.invokeEndTurnEvent();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

// Metodi che il server puo' chiamare 
	@Override
	public void invokePrintEvent(String message) throws RemoteException {
		this.printEvent.invoke(new PrintEvent(message));
	}

	@Override
	public void setClient(RMIClientInterface client) throws RemoteException {
		this.client = client;
	}

	@Override
	public void invokeUpdate(Player player) throws RemoteException {
		this.updatePlayerEvent.invoke(new UpdatePlayerEvent(player));
	}

	@Override
	public void invokeStartGame(Game game, Player player) throws RemoteException {
		this.startGameEvent.invoke(new StartGameEvent(game, player));
	}
	*/

}
