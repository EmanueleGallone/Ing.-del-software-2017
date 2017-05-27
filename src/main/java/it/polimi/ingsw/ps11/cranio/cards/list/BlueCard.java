package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class BlueCard extends DevelopmentCard {
	//carte PERSONAGGI

	public BlueCard(){
		
	}

	@Override
	public void enablePermanentBonus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BlueCard clone() {
		JsonAdapter jsonAdapter = new JsonAdapter(DevelopmentCard.class);
		String string = jsonAdapter.toJson(this);
		return jsonAdapter.fromJson(string, BlueCard.class);
	}
}
