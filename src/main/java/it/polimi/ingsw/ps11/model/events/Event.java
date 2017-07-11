package it.polimi.ingsw.ps11.model.events;

import it.polimi.ingsw.ps11.view.viewGenerica.components.DevelopmentCardView;

/**
 * <h3> Event </h3>
 * <p> Classe che rappresenta un generico evento di gioco.</p>
 * @see DevelopmentCardView
 */
public class Event<TYPE> {

	protected TYPE source;
	
	public Event() {
		source = null;
	}
	
	public Event(TYPE source){
		this.source = source;
	}
	
	public void setSource(TYPE source) {
		this.source = source;
	}
	public TYPE getSource() {
		return source;
	}

}
