package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.json.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class BlueCard extends DevelopmentCard {
	//carte PERSONAGGI

	public BlueCard(){
		
	}
	
	private BlueCard(BlueCard toCopy){
		//copy Constructor
		this.name = toCopy.name;
		this.period = toCopy.period;
		
		for(ResourceList r : toCopy.getCosts())
			this.addCost(r.clone()); //copio i costi
		
		//for(Bonus bonus : toCopy.instantBonus)
			//this.addInstantBonus(bonus.clone());
		
		//for(Bonus bonus : toCopy.permanentBonus)
		//this.addPermanentBonus(bonus.clone());
		//aspetto per i bonus; saranno cambiati
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
