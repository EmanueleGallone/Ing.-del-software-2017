package it.polimi.ingsw.ps11.controller.client.network.socket.connection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.model.events.EventListener;

public class Connection {

	private int port;
	private String server;
	
	private Socket socket;
	
	MessageReceiver receiver = new MessageReceiver();

	
	public Connection(Socket socket){
		this.socket = socket;
	}
	
	public Connection(String server, int port ) {
		this.server = server;
		this.port = port;
	}
	
	public void on() throws UnknownHostException, IOException{
		if(socket == null)
			socket = new Socket(server,port);
		receiver.setSocket(socket);
		new Thread(receiver).start();
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
