package it.polimi.ingsw.ps11.posNetwork.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.posNetwork.Connection;
import it.polimi.ingsw.ps11.posNetwork.InputChangeEvent;

public class MessageReceiver extends Thread{
	
	private Connection connection;
	private BufferedReader reader;
	
	EventHandler<InputChangeEvent> inputChangeEvent = new EventHandler<>();
	EventHandler<Connection> clientDisconnectEvent = new EventHandler<>();
	
	
	public MessageReceiver(Connection connection) throws IOException {
		this.connection = connection;
		reader = new BufferedReader(new InputStreamReader(connection.getSocket().getInputStream()));
	}
	
	
	public EventHandler<InputChangeEvent> getInputChangeEvent() {
		return inputChangeEvent;
	}
	public EventHandler<Connection> getClientDisconnectEvent() {
		return clientDisconnectEvent;
	}
	
	@Override
	public void run() {

		try {
			while (true) {

				String message = reader.readLine();
				System.out.println("message received: " + message);

				inputChangeEvent.invoke(new InputChangeEvent(connection, message));	
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Client disconnesso");
			clientDisconnectEvent.invoke(connection);
		}
	}
}