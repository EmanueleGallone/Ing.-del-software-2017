package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO

	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	public YellowCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
	}

	public int getActiveValue() {
		return activeValue;
	}
	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
	}

	@Override
	public String toString() {
		return "YellowCard [DEFAULT_VALUE=" + DEFAULT_VALUE + ", activeValue=" + activeValue + "]";
	}
	
	@Override
	public YellowCard clone() {
		JsonAdapter jsonAdapter = new JsonAdapter(DevelopmentCard.class);
		String string = jsonAdapter.toJson(this);
		return jsonAdapter.fromJson(string, YellowCard.class);
	}
	
}
