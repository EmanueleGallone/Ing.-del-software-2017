package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> GreenCard </h3>
 * <p> Classe concreta che rappresenta le carte di tipo "Territorio" con colore identificativo Verde. Estende la classe astratta DevelopmentCard.</p>
 * @see DevelopmentCard
 */
public class GreenCard extends DevelopmentCard{
	
	private static final String id = "GreenCard";
	
	public GreenCard() {
		super(id);
		this.activeValue = DEFAULT_VALUE;
		this.period = DEFAULT_VALUE;
	}
	
	public GreenCard(String name) {
		super(id,name);
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
			clone.addCost(r.clone());
		
		clone.instantEffect = instantEffect;
		clone.permanentEffect = permanentEffect;
		
		return clone;
	}
	/** <p> Compara due carte, ritorna true se sono delle stesso tipo e hanno lo stesso nome </p>
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((GreenCard) obj).getName()))
				return true;
		
		return false;
	}
}
