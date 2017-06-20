package it.polimi.ingsw.ps11.model.events;

public interface EventListener<EVENT> {
	
	public abstract void handle(EVENT e);
}
