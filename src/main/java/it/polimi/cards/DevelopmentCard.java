package it.polimi.cards;

import event.Event;
import it.polimi.ingsw.resources.Resource;

//ATTENZIONE: ogni cambiamento che fate nella sovraclasse (Abstract e non) ha ovviamente ripercussioni sulle sottoclassi
//ad esempio: qui c'è il costruttore di DevelopmentCard che instanzia la variabile "activatedEvent"
//se però nelle sottoclassi non utilizzate il "super()" all'interno del costruttore di ogni sottoclasse, la variabile "activatedEvent" 
//non viene istanziata! lascio questo commento come monito per futuri cambiamenti nel costruttore e nelle variabili. ema

public class DevelopmentCard extends Card {
	protected static final int MAX_DECK=96;
	protected static final int DECK_MAX_CARDS_PER_PERIOD=32;
	
	
	protected String name;
	protected Colour colour;
	protected Resource resourceAffected; //the resource that is added to one's personal board. AACHTUNG! sicuramente da modificare. ema
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


	public void active() {
		activatedEvent.preEventNotify();
		// Do something
		activatedEvent.postEventNotify();
	}

	public Event ActiveEvent() {
		return this.activatedEvent;
	}
	
}
