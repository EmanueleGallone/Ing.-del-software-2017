package it.polimi.ingsw.ps11.beta.client.socket.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import it.polimi.ingsw.ps11.beta.client.socket.connection.events.DisconnectEvent;
import it.polimi.ingsw.ps11.beta.client.socket.connection.events.NewMessageEvent;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public class MessageReceiver implements Runnable {

	
	private Socket socket;
	
	private EventHandler<NewMessageEvent> newMessageEvent = new EventHandler<>();
	private EventHandler<DisconnectEvent> disconnectEvent = new EventHandler<>();
	
	public MessageReceiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {

				String message = reader.readLine();
				System.out.println("message received: " + message);
				newMessageEvent.invoke(new NewMessageEvent(message));
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Client disconnesso");
			disconnectEvent.invoke(new DisconnectEvent());
		}
	}
	

	public void newMessageEvent(EventListener<NewMessageEvent> newMessageListener){
		newMessageEvent.attach(newMessageListener);
	}
	
	public void disconnectEvent(EventListener<DisconnectEvent> disconnectListener){
		disconnectEvent.attach(disconnectListener);
	}
}
