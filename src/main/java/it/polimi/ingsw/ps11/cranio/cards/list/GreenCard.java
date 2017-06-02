package it.polimi.ingsw.ps11.cranio.cards.list;

import java.util.Arrays;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class GreenCard extends DevelopmentCard {
	//carte Territori
	
	
	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	
	public GreenCard() {
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
		return "GreenCard [DEFAULT_VALUE=" + DEFAULT_VALUE + ", activeValue=" + activeValue 
				+ "\nPermanentBonus: " + Arrays.asList(permanentBonus) 
				+  "]";
	}
	
	@Override
	public GreenCard clone() {
		JsonAdapter jsonAdapter = new JsonAdapter(DevelopmentCard.class);
		String string = jsonAdapter.toJson(this);
		return jsonAdapter.fromJson(string, GreenCard.class);
	}
}
