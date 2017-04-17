package it.polimi.cards;

import event.Activable;
import event.Event;
import event.Observers;
import it.polimi.ingsw.resources.Resource;

public class DevelopmentCard extends Card implements Activable {
	protected static final int MAX_DECK=96;
	protected static final int DECK_MAX_CARDS_PER_PERIOD=32;
	
	
	protected String name;
	protected Colour colour;
	protected Resource resourceAffected; //the resource that is added to one's personal board. AACHTUNG! sicuramente da modificare
	protected String description; //a description of what it does
	protected Resource requirements;
	protected int period;
	
	protected Event activatedEvent; //Oggetto che definisce l'evento "Attivato"
	
	public DevelopmentCard() {
		activatedEvent = new Event(this);
	}
	
	@Override
	public String toString() {
		return "DevelopmentCard [name=" + name + ", colour=" + colour + ", resourceAffected=" + resourceAffected
				+ ", description=" + description + ", requirements=" + requirements + ", period=" + period + "]";
	}


	@Override
	public void active() {
		activatedEvent.preEventNotify();
		// Do something
		activatedEvent.postEventNotify();
	}
	
	@Override //Metodo che serve ad un "observer" per iniziare ad osservare l'evento "activated"
	public void observActiveEvent(Observers observer) {
		activatedEvent.attach(observer);
	}

	@Override //Metodo per smettere di osservare l'evento "activated"
	public void deobservActiveEvent(Observers observer) {
		activatedEvent.deatach(observer);
	}
	
}
