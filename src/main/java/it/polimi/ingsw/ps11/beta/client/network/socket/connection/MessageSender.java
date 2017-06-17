package it.polimi.ingsw.ps11.beta.client.network.socket.connection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class MessageSender extends Thread{
	
	private Socket socket;
	private PrintStream writer;
	private String message;
	
	public MessageSender(Socket socket,String message) throws IOException {
		this.socket = socket;
		this.message = message;
		writer = new PrintStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		this.send(message);
	}
	
	public void send(String message){
		message = message.replaceAll("\n", "");
		writer.println(message);
	}
}