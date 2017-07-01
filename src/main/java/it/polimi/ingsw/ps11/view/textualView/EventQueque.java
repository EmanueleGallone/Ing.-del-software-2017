package it.polimi.ingsw.ps11.view.textualView;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class EventQueque<T> extends EventHandler<T> {

	@Override
	public void invoke(T parameter) {
		for(EventListener<T> listener:eventListeners){
			listener.handle(parameter);
			detach(listener);
			attach(listener);
			return;
		}
	}
}
