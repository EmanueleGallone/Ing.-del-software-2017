package it.polimi.ingsw.ps11.model.cards.leaderCards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3>Leader Card</h3>
 * <p> Classe che rappresenta le carte leader. Identificata da una resourceList che rappresenta i requisiti, un bonus, un numero di carte richieste.
 * </p>
 */
public abstract class LeaderCard extends Card {
	
	private Map<String, Integer> cardsNumber = new HashMap<>(); //trovare nomi migliori
	private ResourceList resourceList = new ResourceList();
	
	public LeaderCard(String name){
		super(name);
	}
	
	public boolean isSatisfied(Player player){
		//isUsable
		boolean checkResource = false;
		if (player.getResourceList().greaterEquals(resourceList)) 
			checkResource = true;		
		
		ArrayList<DevelopmentCard> deck;
		for(Entry<String, Integer> entry : cardsNumber.entrySet()){
			deck = player.getCardManager().getCardList(entry.getKey());
			if (deck != null && deck.size() >= cardsNumber.get(entry.getKey()) && checkResource) {
				return true;
			}
			
		}
		return false;
			
	}
	
	public Map<String, Integer> getCardsNumber() {
		return cardsNumber;
	}
	
	public void setResourceList(ResourceList resourceList) {
		this.resourceList = resourceList;
	}
	
//	@Override
//	public Card clone() {
//		return new LeaderCard(this.name);
//	}
	
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
