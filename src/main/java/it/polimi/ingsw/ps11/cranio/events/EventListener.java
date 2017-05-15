package it.polimi.ingsw.ps11.cranio.events;

public interface EventListener<EVENT> {
	
	public abstract void handle(EVENT event);
}
