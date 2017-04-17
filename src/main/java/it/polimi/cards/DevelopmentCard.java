package it.polimi.cards;

import event.Activable;
import event.Event;
import event.Observer;
import it.polimi.ingsw.resources.Resource;

public class DevelopmentCard extends Card implements Activable {
	protected static final int MAX_DECK=96;
	protected static final int DECK_MAX_CARDS_PER_PERIOD=32;
	public static final int MAX_YELLOW_CARDS=6;
	public static final int MAX_GREEN_CARDS=6;
	
	protected String name;
	protected Colour colour;
	protected Resource resourceAffected; //the resource that is added to one's personal board. AACHTUNG! sicuramente da modificare
	protected String description; //a description of what it does
	protected Resource requirements;
	protected int period;
	
	protected Event activatedEvent = new Event(); //Oggetto che definisce l'evento "Attivato"
	
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
	public void observActiveEvent(Observer observer) {
		activatedEvent.attach(observer);
	}

	@Override //Metodo per smettere di osservare l'evento "activated"
	public void deobservActiveEvent(Observer observer) {
		activatedEvent.deatach(observer);
	}
	
}
