package it.polimi.ingsw.ps11.beta.server.network.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.network.rmi.RMIClientInterface;
import it.polimi.ingsw.ps11.beta.server.events.PrintEvent;
import it.polimi.ingsw.ps11.beta.server.events.StartGameEvent;
import it.polimi.ingsw.ps11.beta.server.events.UpdatePlayerEvent;
import it.polimi.ingsw.ps11.beta.server.network.RemoteServer;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class RMIRemoteServer extends RemoteServer implements RMIServerInterface, Serializable{

	private RMIClientInterface client;
	
	public RMIRemoteServer() {
	}
	
	public RMIRemoteServer(RMIClientInterface client) {
		this.client = client;
	}
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

}
