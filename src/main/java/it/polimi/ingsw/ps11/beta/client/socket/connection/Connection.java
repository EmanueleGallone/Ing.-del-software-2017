package it.polimi.ingsw.ps11.beta.client.socket.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.beta.client.socket.connection.events.DisconnectEvent;
import it.polimi.ingsw.ps11.beta.client.socket.connection.events.NewMessageEvent;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public class Connection {

	private int port;
	private String server;
	
	private Socket socket;
	
	MessageReceiver receiver;

	
	public Connection(String server, int port ) {
		this.server = server;
		this.port = port;
	}
	
	public void on() throws UnknownHostException, IOException{
		socket = new Socket(server,port);
	}
	
	public void send(String message) throws IOException{
		new MessageSender(socket, message).run();
	}
	
	
	public void newMessageEvent(EventListener<NewMessageEvent> newMessageListener){
		receiver.newMessageEvent(newMessageListener);
	}
	
	public void disconnectEvent(EventListener<DisconnectEvent> disconnectListener){
		receiver.disconnectEvent(disconnectListener);
	}
	
}
