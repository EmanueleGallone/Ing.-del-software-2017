package it.polimi.ingsw.ps11.posNetwork.networking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import it.polimi.ingsw.ps11.posNetwork.Connection;

public class MessageSender extends Thread{
	
	private Socket socket;
	private PrintStream writer;
	private String message;
	
	public MessageSender(Connection connection,String message) throws IOException {
		this.socket = connection.getSocket();
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