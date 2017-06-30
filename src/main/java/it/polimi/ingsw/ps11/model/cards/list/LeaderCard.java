package it.polimi.ingsw.ps11.model.cards.list;

import it.polimi.ingsw.ps11.model.bonus.ema.Bonus;
import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Leader Card</h3>
 * <p> Classe che rappresenta le carte leader. Identificata da una resourceList che rappresenta i requisiti, un bonus, un numero di carte richieste.</p>
 */
public class LeaderCard extends Card {
	private ResourceList requirements; //per i requisiti e/o il bonus
	private Bonus bonus; //rappresenta l'effetto della carta
	private int counter = 0; //numero di carte che il giocatore deve avere.
	private String cardClass; //tipo di carta che il giocatore deve avere
	
	public LeaderCard(String name){
		super(name);
	}

	
	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	
	public void setRequirement(ResourceList resourceList) {
		this.requirements = resourceList;
	}
	public void setCardClass(String cardClass) {
		this.cardClass = cardClass;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	
	@Override
	public Card clone() {
		//LeaderCard clone = new LeaderCard(this.name);
		return new LeaderCard(this.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((LeaderCard) obj).getName()))
				return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return "LeaderCard [name=" + name + "]";
	}
	

}
