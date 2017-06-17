package it.polimi.ingsw.ps11.beta.client;

import it.polimi.ingsw.ps11.beta.server.events.PrintEvent;
import it.polimi.ingsw.ps11.beta.server.events.StartGameEvent;
import it.polimi.ingsw.ps11.beta.server.events.UpdatePlayerEvent;
import it.polimi.ingsw.ps11.beta.server.network.RemoteServer;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.View;

public abstract class Client implements Runnable {
	
	private View view;
	protected RemoteServer server;
	
	public Client(View view) {
		this.view = view;
	}

	
	public abstract void start() throws InternalError;
	
	@Override
	public void run() {
		this.start();
	}
	
	protected void attachListener(){
		server.printEvent(printListener);
		server.updatePlayerEvent(updatePlayerListener);
		server.startGameEvent(startGameListener);
	}
	
	
	private EventListener<PrintEvent> printListener = new EventListener<PrintEvent>() {
		
		@Override
		public void handle(PrintEvent e) {
			view.out(e.getMessage());
		}
	};
	
	private EventListener<StartGameEvent> startGameListener = new EventListener<StartGameEvent>() {
		
		@Override
		public void handle(StartGameEvent e) {
			
		}
	};
	
	
	private EventListener<UpdatePlayerEvent> updatePlayerListener = new EventListener<UpdatePlayerEvent>() {
		
		@Override
		public void handle(UpdatePlayerEvent e) {
			
		}
	};
	
	
}
