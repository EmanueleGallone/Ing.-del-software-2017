package it.polimi.ingsw.ps11.alpha.socket.client;

import java.io.IOException;

import it.polimi.ingsw.ps11.alpha.network.client.Client;
import it.polimi.ingsw.ps11.alpha.socket.InputChangeEvent;
import it.polimi.ingsw.ps11.alpha.socket.connection.Connection;
import it.polimi.ingsw.ps11.alpha.socket.server.SocketServer;
import it.polimi.ingsw.ps11.cranio.events.EventListener;


public class SocketClient<T extends Connection<?,?>> extends Client {
	
	private T connection;
	private Thread messageReceiver;
	
	public SocketClient(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public SocketClient(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public SocketClient(String serverAddress, int port) {
		super(serverAddress,port);
	}
	
	public SocketClient(T connection){
		this.connection = connection;
	}
	
//_______________________________________________

	@Override
	public void on() throws InternalError {
		try {
			connection.on();
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
	
}
