package it.polimi.ingsw.ps11.alpha.socket.client;

import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.alpha.network.client.Client;
import it.polimi.ingsw.ps11.alpha.socket.InputChangeEvent;
import it.polimi.ingsw.ps11.alpha.socket.connection.MessageReceiver;
import it.polimi.ingsw.ps11.alpha.socket.server.SocketServer;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class SocketClient extends Client {
	
	private Socket socket;
	private Thread messageReceiver;
	
	public SocketClient(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public SocketClient(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public SocketClient(String serverAddress, int port) {
		super(new SocketServer(serverAddress,port));
	}
	
	public SocketClient(Socket socket){
		this.socket = socket;
	}
	
//_______________________________________________

	@Override
	public void on() throws InternalError {
		try {
			socket = new Socket(serverAddress, port);
			MessageReceiver mReceiver = new MessageReceiver(socket);
			mReceiver.getInputChangeEvent().attach(receiver);
			messageReceiver = new Thread(mReceiver);
			messageReceiver.start();
		} catch (IOException e) {
			throw new InternalError(e);
		}
	}
	
	private EventListener<InputChangeEvent> receiver = new EventListener<InputChangeEvent>() {

		@Override
		public void handle(InputChangeEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
//_______________________________________________

	@Override
	public void out(String message) throws RemoteException {
		
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
