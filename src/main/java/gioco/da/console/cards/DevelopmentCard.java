package gioco.da.console.cards;

import it.polimi.ingsw.resources.Resource;

public class DevelopmentCard extends Card {

	protected static final int MAX_DECK=96;
	protected static final int DECK_MAX_CARDS_PER_PERIOD=32;
	
	
	protected String name;
	protected Colour colour;
	protected Resource resourceAffected; //the resource that is added to one's personal board. AACHTUNG! sicuramente da modificare. ema
	protected String description; //a description of what it does
	protected Resource requirements;
	protected int period;
	
	//protected Event activatedEvent; //Oggetto che definisce l'evento "Attivato"
	
	public DevelopmentCard() {
		//activatedEvent = new DevelopmentCardEvent(this);
	}
	
	@Override
	public String toString() {
		return "DevelopmentCard [name=" + name + ", colour=" + colour + ", resourceAffected=" + resourceAffected
				+ ", description=" + description + ", requirements=" + requirements + ", period=" + period + "]";
	}

}
