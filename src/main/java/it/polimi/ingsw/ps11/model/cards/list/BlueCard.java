package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> BlueCard </h3>
 * <p> Classe concreta che rappresenta le carte di tipo "Personaggio" con colore identificativo Blu. Estende la classe astratta DevelopmentCard. </p>
 * @see DevelopmentCard
 */
public class BlueCard extends DevelopmentCard {
	
	/**<h3>  </h3>
	 * <p> Costruttore di base, setta tutti i valori a DEFAULT_VALUE </p>
	 */
	public BlueCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
		this.period = DEFAULT_VALUE;
	}
	
	/** <p> Costruttore che richiede una stringa per il nome della carta </p>
	 */
	public BlueCard(String name) {
		this();
		setName(name);
	}

	@Override
	public BlueCard clone() {
		BlueCard clone = new BlueCard();
		
		clone.name = this.name;
		clone.period = this.period;
		
		for(ResourceList r : this.getCosts())
			clone.addCost(r.clone()); 
		
		clone.instantEffect = instantEffect;
		clone.permanentEffect = permanentEffect;
		
		return clone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((BlueCard) obj).getName()))
				return true;
		
		return false;
	}
}
