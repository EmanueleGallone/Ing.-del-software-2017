package it.polimi.ingsw.ps11.alpha.client.socket;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.alpha.client.Client;
import it.polimi.ingsw.ps11.alpha.server.socket.SocketServer;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class SocketClient extends Client {
	
	
	public SocketClient(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public SocketClient(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public SocketClient(String serverAddress, int port) {
		super(serverAddress,port);
	}
	
//_______________________________________________

	@Override
	public void on() {
		this.server = new SocketServer();
	}
	
//_______________________________________________

	@Override
	public void out(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Game game) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Board board) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Player player) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
