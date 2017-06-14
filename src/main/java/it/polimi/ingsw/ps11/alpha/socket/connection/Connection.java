package it.polimi.ingsw.ps11.alpha.socket.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.alpha.socket.InputChangeEvent;
import it.polimi.ingsw.ps11.alpha.socket.Message;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public class Connection<T extends Message<?>,K extends Message<?>> {

	//T e' il tipo di messaggi che riceve e K e' il tipo di messaggi che manda
	
	private Socket socket;
	protected final static int DEFAULT_PORT = 60000;
	protected final static String DEFAULT_SERVER = "localhost";
	
	private int port;
	private String server;
	
	private MessageReceiver<T> messageReceiver;

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
		messageReceiver = new MessageReceiver<T>(this);
		messageReceiver.start();
	}
	
	public Socket getSocket() {
		return socket;
	}
	
// Event____________________________________
	
	public void inputChangeEvent(EventListener<InputChangeEvent<T>> listener){
		messageReceiver.getInputChangeEvent().attach(listener);
	}
	
	public void clientDisconnectEvent(EventListener<Connection<T,?>> listener){
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
	
	public void send(K message){
		
		MessageBuilder<K> builder = new MessageBuilder<K>();
		String string = builder.serialize(message);
		this.send(string);
	}

}
