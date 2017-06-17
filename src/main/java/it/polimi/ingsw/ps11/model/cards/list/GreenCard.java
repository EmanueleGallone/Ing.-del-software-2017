package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

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
	public GreenCard clone() {
		GreenCard clone = new GreenCard();
		
		clone.activeValue = this.activeValue;
		clone.name = this.name;
		clone.period = this.period;
		
		for(ResourceList r : this.getCosts())
			clone.addCost(r.clone()); //copio i costi
		
		//for(Bonus bonus : this.instantBonus)
			//clone.addInstantBonus(bonus.clone());
		
		//for(Bonus bonus : this.permanentBonus)
			//clone.addPermanentBonus(bonus.clone());
		//aspetto per i bonus; saranno cambiati
		
		return clone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((YellowCard) obj).getName()))
				return true;
		
		return false;
	}
}
