package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class PurpleCard extends DevelopmentCard {
	//carte IMPRESE
	
	public PurpleCard(){
		super();
	}

	@Override
	public PurpleCard clone() {
		PurpleCard clone = new PurpleCard();

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
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((PurpleCard) obj).getName()))
				return true;
		
		return false;
	}
}
