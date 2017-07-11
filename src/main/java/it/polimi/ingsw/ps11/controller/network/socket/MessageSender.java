package it.polimi.ingsw.ps11.controller.network.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 * <h3> MessageSender. </h3>
 * <p> Classe che gestisce la preparazione e succesivo invio di un messaggio tramite socket.</p>
 */
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