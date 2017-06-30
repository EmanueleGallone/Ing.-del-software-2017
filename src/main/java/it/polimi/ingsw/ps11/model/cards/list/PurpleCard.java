package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> PurpleCard </h3>
 * <p> Classe concreta che rappresenta le carte di tipo "Impresa" con colore identificativo Viola. Estende la classe astratta DevelopmentCard. </p>
 * @see DevelopmentCard
 */
public class PurpleCard extends DevelopmentCard {
	
	public PurpleCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
		this.period = DEFAULT_VALUE;
	}
	
	public PurpleCard(String name) {
		this();
		setName(name);
	}

	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
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
	
	/** <p> Compara due carte, ritorna true se sono delle stesso tipo e hanno lo stesso nome </p>
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((PurpleCard) obj).getName()))
				return true;
		
		return false;
	}
}
