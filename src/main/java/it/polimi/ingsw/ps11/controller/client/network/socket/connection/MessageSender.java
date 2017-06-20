package it.polimi.ingsw.ps11.controller.client.network.socket.connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageSender extends Thread{
	
	private Socket socket;
	private Object message;
	ObjectOutputStream writer;
	
	public MessageSender(Socket socket,Object message) throws IOException {
		this.socket = socket;
		this.message = message;
		writer = new ObjectOutputStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		this.send(message);
	}
	
	public void send(Object message){
		try {
			writer.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}