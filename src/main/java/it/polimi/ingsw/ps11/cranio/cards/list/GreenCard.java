package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class GreenCard extends DevelopmentCard {
	//carte Territori
	
	
	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	
	public GreenCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
	}
	
	private GreenCard(GreenCard toCopy){
		//copy Constructor
		this.activeValue = toCopy.activeValue;
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
	
	public int getActiveValue() {
		return activeValue;
	}
	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
	}
	
	@Override
	public GreenCard clone() {
		JsonAdapter jsonAdapter = new JsonAdapter(DevelopmentCard.class);
		String string = jsonAdapter.toJson(this);
		return jsonAdapter.fromJson(string, GreenCard.class);
	}
}
