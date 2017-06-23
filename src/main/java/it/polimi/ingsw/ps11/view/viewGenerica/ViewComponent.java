package it.polimi.ingsw.ps11.view.viewGenerica;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public abstract class ViewComponent implements ViewComponentInterface {

	protected EventHandler<ViewEventInterface> eventHandler = new EventHandler<>();
	
	public void attach(EventListener<ViewEventInterface> listener){
		this.eventHandler.attach(listener);
	}
	
}
