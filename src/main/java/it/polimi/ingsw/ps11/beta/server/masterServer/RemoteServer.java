package it.polimi.ingsw.ps11.beta.server.masterServer;

import it.polimi.ingsw.ps11.beta.client.events.PrintEvent;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public abstract class RemoteServer  implements ServerInterface{

	//Events that server can invoke
	protected EventHandler<PrintEvent> printEvent = new EventHandler<>();
	
	public void printEvent(EventListener<PrintEvent> listener) {
		printEvent.attach(listener);
	}
	
}
