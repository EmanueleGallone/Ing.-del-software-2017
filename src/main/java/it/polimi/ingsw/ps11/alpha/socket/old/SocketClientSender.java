package it.polimi.ingsw.ps11.alpha.socket.old;

import java.net.Socket;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.alpha.network.client.ClientInterface;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class SocketClientSender implements ClientInterface {

	private Socket socket;
	
	public SocketClientSender(Socket socket){
		this.socket = socket;
	}
	
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
