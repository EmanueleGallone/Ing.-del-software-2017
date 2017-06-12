package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.json.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO

	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	public YellowCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
	}
	
	private YellowCard(YellowCard toCopy){
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
