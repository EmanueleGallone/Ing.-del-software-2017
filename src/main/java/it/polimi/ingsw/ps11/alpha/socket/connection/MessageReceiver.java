package it.polimi.ingsw.ps11.alpha.socket.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import it.polimi.ingsw.ps11.alpha.socket.InputChangeEvent;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;

public class MessageReceiver extends Thread{
	
	private Socket connection;
	private BufferedReader reader;
	
	EventHandler<InputChangeEvent> inputChangeEvent = new EventHandler<>();
	EventHandler<Socket> clientDisconnectEvent = new EventHandler<>();
	
	
	public MessageReceiver(Socket connection) throws IOException {
		this.connection = connection;
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	}
	
	
	public EventHandler<InputChangeEvent> getInputChangeEvent() {
		return inputChangeEvent;
	}
	public EventHandler<Socket> getClientDisconnectEvent() {
		return clientDisconnectEvent;
	}
	
	@Override
	public void run() {

		try {
			while (true) {

				String message = reader.readLine();
				System.out.println("message received: " + message);

				//MessageBuilder messageBuilder = new MessageBuilder();
				//Message<?> m = messageBuilder.deserialize(message);
				//inputChangeEvent.invoke(new InputChangeEvent(connection, m));	
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Client disconnesso");
			clientDisconnectEvent.invoke(connection);
		}
	}
}