package it.polimi.ingsw.ps11.controller.client;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.MessageArrivedEvent;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.events.EventManager;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class Client implements Runnable {
	
	private View view;
	protected Connection connection;
	public ClientLogic clientLogic = new ClientLogic();
	
	EventManager manager = new EventManager();
	
	public Client(View view, Connection connection) {
		this.view = view;
		this.connection = connection;
	}

	@Override
	public void run() {
		try {
			connection.attachMessageListener(serverListener);
			connection.on();
			//new Thread(view).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private transient EventListener<MessageArrivedEvent> serverListener = new EventListener<MessageArrivedEvent>() {

		@Override
		public void handle(MessageArrivedEvent e) {
			e.getMessage().accept(clientLogic);;		
		}
	};

	
}
