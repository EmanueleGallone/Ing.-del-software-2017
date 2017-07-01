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
	
	protected Map<String, Integer> cardsNumber = new HashMap<>(); //trovare nomi migliori
	protected ResourceList requiredResources = new ResourceList();
	
	public LeaderCard(String name){
		super(name);
	}
	
	
	
	
	public boolean isSatisfied(Player player) {
		//sono tutte uguali. va ridefinita solo per quella carta che vuole 6 carte dello stesso tipo, di qualunque colore.
		int howManyEntries;
		boolean checkResource = false;
		if (player.getResourceList().greaterEquals(requiredResources)) 
			checkResource = true;
		
		ArrayList<DevelopmentCard> deck;
		howManyEntries = cardsNumber.size(); //deve scorrere tutta la mappa. i costi sono in AND
		
		for(Entry<String, Integer> entry : cardsNumber.entrySet()){ 
			deck = player.getCardManager().getCardList(entry.getKey());
			if (deck != null && deck.size() >= cardsNumber.get(entry.getKey())) { //se il numero di carte del giocatore è > di quelle necessarie, diminuisco il contatore.
				howManyEntries--;
			}		
		}
		
		if (checkResource && howManyEntries == 0)// arrivato qui, se le condizioni sono true, vuol dire che le risorse le ha, e anche tutte le carte.
			return true;
		
		
		return false; //se una delle due condizioni dell'if precedente non è soddisfatta, allora è false.
		
	}
	
	public Map<String, Integer> getCardsNumber() {
		return cardsNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(this.getClass() == obj.getClass() && this.name.equalsIgnoreCase(((LeaderCard) obj).getName()))
				return true;
		
		return false;
	}
	
	public ResourceList getRequiredResources() {
		return requiredResources;
	}
	public void setRequiredResources(ResourceList resourceList) {
		this.requiredResources = resourceList;
	}
	
	@Override
	public String toString() {
		return "LeaderCard [name=" + name + "]";
	}
	

}
