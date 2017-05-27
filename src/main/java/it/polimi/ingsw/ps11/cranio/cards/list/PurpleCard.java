package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class PurpleCard extends DevelopmentCard {
	//carte IMPRESE
	public PurpleCard(){
		
	}

	@Override
	public void enablePermanentBonus() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PurpleCard clone() {
		JsonAdapter jsonAdapter = new JsonAdapter(DevelopmentCard.class);
		String string = jsonAdapter.toJson(this);
		return jsonAdapter.fromJson(string, PurpleCard.class);
	}
}
