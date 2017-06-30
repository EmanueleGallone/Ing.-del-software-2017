package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> YellowCard </h3>
 * <p> Classe concreta che rappresenta le carte di tipo "Edificio" con colore identificativo Giallo. Estende la classe astratta DevelopmentCard. </p>
 * @see DevelopmentCard
 */
public class YellowCard extends DevelopmentCard{
	
	public YellowCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
		this.period = DEFAULT_VALUE;
	}
	
	public YellowCard(String name) {
		this();
		setName(name);
	}

	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
	}

	@Override
	public YellowCard clone() {
		YellowCard clone = new YellowCard();
		
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
