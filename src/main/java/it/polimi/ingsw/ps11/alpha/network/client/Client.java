package it.polimi.ingsw.ps11.alpha.network.client;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.mvc.view.View;

public abstract class Client implements ClientInterface{
	
	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	protected int port;
	protected String serverAddress;
	
	protected View view;

	public Client(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public Client(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public Client(String serverAddress, int port) {
		this.port = port;
		this.serverAddress = serverAddress;
	}

//_____________________________________
	
	public abstract void on() throws InternalError;
//_____________________________________
	
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
