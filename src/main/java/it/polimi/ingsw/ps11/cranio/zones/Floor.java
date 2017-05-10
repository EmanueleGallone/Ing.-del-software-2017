package it.polimi.ingsw.ps11.cranio.zones;

public class Floor<CARD_TYPE,RESOURCE_TYPE> {
	
	private ActionSpace<RESOURCE_TYPE> actionSpace;
	private CARD_TYPE card;
	
	public Floor(ActionSpace<RESOURCE_TYPE> actionSpace){
		this.actionSpace = actionSpace;
	
	}
	
	public Floor(ActionSpace<RESOURCE_TYPE> actionSpace,CARD_TYPE card){
		this(actionSpace);
		this.card = card;
	}
	
	public CARD_TYPE getCard() {
		return (CARD_TYPE) card;
	}
	
	
}
