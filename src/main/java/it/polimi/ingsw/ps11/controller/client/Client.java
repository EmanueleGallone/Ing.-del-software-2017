package it.polimi.ingsw.ps11.controller.client;

import java.io.IOException;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.events.EventManager;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class Client implements Runnable {
	
	private View view;
	protected Connection connection;
	
	EventManager manager = new EventManager();
	
	public Client(View view, Connection connection) {
		this.view = view;
		this.connection = connection;
	}

	@Override
	public void run() {
		try {
			connection.on();
			//new Thread(view).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
