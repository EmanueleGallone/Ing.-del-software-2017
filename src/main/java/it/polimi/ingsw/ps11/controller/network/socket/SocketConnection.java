package it.polimi.ingsw.ps11.controller.network.socket;

import java.io.IOException;
import java.net.Socket;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class SocketConnection extends Connection implements EventListener<Message>{

	private Socket socket;
	MessageReceiver receiver = new MessageReceiver();
	
	public SocketConnection() {
		
	}
	
	public SocketConnection(Socket socket){
		this.socket = socket;
		try {
			this.on();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SocketConnection(String serverAddress) {
		super(serverAddress);
	}
	
	public SocketConnection(int port) {
		super(port);
	}
	
	public SocketConnection(String serverAddress, int port) {
		super(serverAddress,port);
	}
	
	@Override
	public void on() throws IOException {
		if(socket == null)
			socket = new Socket(getServerAddress(),getPort());
		receiver.setSocket(socket);
		receiver.attachMessageListener(this);
		new Thread(receiver).start();
	}
	
	@Override
	public void send(Message message) throws IOException{
		try {
			new MessageSender(socket, message).run();
		} catch (IOException e) {
			System.err.println("Soket MessageSender: The connection has been closed");
		}
		
	}

	@Override
	public void handle(Message e) {
		invokeMessageEvent(e);
	}

}
