package it.polimi.ingsw.ps11.network.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.network.InputChangeEvent;
import it.polimi.ingsw.ps11.network.genericMessage.Message;

public class Connection {

	private Socket socket;
	private final static int DEFAULT_PORT = 60000;
	private final static String DEFAULT_SERVER = "localhost";
	
	private int port;
	private String server;
	
	private MessageReceiver messageReceiver;

	public Connection() {
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public Connection(String server) {
		this(server, DEFAULT_PORT);
	}
	
	public Connection(Socket socket) {
		this.socket = socket;
	}
	
	public Connection(String server, int port ) {
		this.server = server;
		this.port = port;
	}
	
	public void on() throws UnknownHostException, IOException{
		if(socket == null)
			this.socket = new Socket(server, port);
		messageReceiver = new MessageReceiver(this);
		messageReceiver.start();
	}
	
	public Socket getSocket() {
		return socket;
	}
	
// Event____________________________________
	
	public void inputChangeEvent(EventListener<InputChangeEvent> listener){
		messageReceiver.getInputChangeEvent().attach(listener);
	}
	
	public void clientDisconnectEvent(EventListener<Connection> listener){
		messageReceiver.getClientDisconnectEvent().attach(listener);
	}
	
// Receive message ___________________________
	
	
	private void send(String message){
		try {
			new MessageSender(this, message).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(Message<?> message){
		
		MessageBuilder builder = new MessageBuilder();
		String string = builder.serialize(message);
		this.send(string);
	}

}
