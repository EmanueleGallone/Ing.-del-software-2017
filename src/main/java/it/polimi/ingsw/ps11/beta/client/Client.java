package it.polimi.ingsw.ps11.beta.client;

import it.polimi.ingsw.ps11.beta.client.events.PrintEvent;
import it.polimi.ingsw.ps11.beta.server.RemoteServer;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.mvc.view.View;

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
	}
	
	
	private EventListener<PrintEvent> printListener = new EventListener<PrintEvent>() {
		
		@Override
		public void handle(PrintEvent e) {
			System.out.println("Sono un generico client " + e.getMessage());
		}
	};
	
}
