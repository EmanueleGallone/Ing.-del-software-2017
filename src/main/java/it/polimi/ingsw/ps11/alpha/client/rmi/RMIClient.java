package it.polimi.ingsw.ps11.alpha.client.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.alpha.client.Client;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class RMIClient extends Client {

	public RMIClient() throws RemoteException {
		this(DEFAULT_SERVER,DEFAULT_PORT);
	}
	
	public RMIClient(String serverAddress) throws RemoteException {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public RMIClient(String serverAddress, int port) throws RemoteException {
		super(serverAddress,port);
		UnicastRemoteObject.exportObject(this, DEFAULT_PORT);
	}
	
//________________________________
	
	@Override
	public void out(String message) throws RemoteException {
		view.out(message);
	}

	@Override
	public void update(Game game) throws RemoteException {
		view.update(game);
	}

	@Override
	public void update(Board board) throws RemoteException {
		view.update(board);
	}

	@Override
	public void update(Player player) throws RemoteException {
		view.update(player);
	}
}
