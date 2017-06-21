package it.polimi.ingsw.ps11.model.oldGameLogics.events.listener;

import java.io.Serializable;

public interface EventListener<EVENT> extends Serializable {
	
	public abstract void handle(EVENT e);
}
