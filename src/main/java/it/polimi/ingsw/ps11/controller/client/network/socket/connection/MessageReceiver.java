package it.polimi.ingsw.ps11.controller.client.network.socket.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class MessageReceiver implements Runnable {

	
	private Socket socket;
	
	private EventHandler<MessageArrivedEvent> newMessageEvent = new EventHandler<>();
	private EventHandler<DisconnectEvent> disconnectEvent = new EventHandler<>();
	
	public MessageReceiver() {

	}
	
	public MessageReceiver(Socket socket) {
		this.socket = socket;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		ObjectInputStream reader;
		
		try {
			reader = new ObjectInputStream(socket.getInputStream());
			while (true) {

				Message message = (Message) reader.readObject();
				//System.out.println("message received: " + message);
				newMessageEvent.invoke(new MessageArrivedEvent(message));
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Client disconnesso");
			disconnectEvent.invoke(new DisconnectEvent());
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.err.println("Messaggio non valido");
		}
	}
	

	public void attachMessageListener(EventListener<MessageArrivedEvent> newMessageListener){
		newMessageEvent.attach(newMessageListener);
	}
	
	public void disconnectEvent(EventListener<DisconnectEvent> disconnectListener){
		disconnectEvent.attach(disconnectListener);
	}
}
