package it.polimi.ingsw.ps11.model.events;

import java.io.Serializable;

public interface EventListener<EVENT> extends Serializable {
	
	public abstract void handle(EVENT e);
}
