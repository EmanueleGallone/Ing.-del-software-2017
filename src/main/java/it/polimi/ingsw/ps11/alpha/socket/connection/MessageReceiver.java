package it.polimi.ingsw.ps11.alpha.socket.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.polimi.ingsw.ps11.alpha.socket.InputChangeEvent;
import it.polimi.ingsw.ps11.alpha.socket.Message;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;

public class MessageReceiver<T extends Message<?>> extends Thread{
	
	private Connection<T,?> connection;
	private BufferedReader reader;
	
	EventHandler<InputChangeEvent<T>> inputChangeEvent = new EventHandler<>();
	EventHandler<Connection<T,?>> clientDisconnectEvent = new EventHandler<>();
	
	
	public MessageReceiver(Connection<T,?> connection) throws IOException {
		this.connection = connection;
		reader = new BufferedReader(new InputStreamReader(connection.getSocket().getInputStream()));
	}
	
	
	public EventHandler<InputChangeEvent<T>> getInputChangeEvent() {
		return inputChangeEvent;
	}
	public EventHandler<Connection<T,?>> getClientDisconnectEvent() {
		return clientDisconnectEvent;
	}
	
	@Override
	public void run() {

		try {
			while (true) {

				String message = reader.readLine();
				System.out.println("message received: " + message);

				MessageBuilder<T> messageBuilder = new MessageBuilder<T>();
				T m = messageBuilder.deserialize(message);
				inputChangeEvent.invoke(new InputChangeEvent<T>(connection, m));	
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Client disconnesso");
			clientDisconnectEvent.invoke(connection);
		}
	}
}