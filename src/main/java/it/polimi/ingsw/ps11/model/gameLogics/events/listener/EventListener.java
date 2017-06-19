package it.polimi.ingsw.ps11.model.gameLogics.events.listener;

import java.io.Serializable;

public interface EventListener<EVENT> extends Serializable {
	
	public abstract void handle(EVENT e);
}
