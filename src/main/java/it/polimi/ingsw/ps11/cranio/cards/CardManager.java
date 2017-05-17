package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;
import java.util.HashMap;


public class CardManager {
	
	private HashMap<Class<? extends DevelopmentCard> , ArrayList<DevelopmentCard>> cards = new HashMap<>();
	
	public CardManager(ArrayList<DevelopmentCard> cards) {
		for(DevelopmentCard card : cards){
			addCard(card);
		}
	}
	
	
// Start logic
	
	public <T extends DevelopmentCard> boolean addCard(T card){
		
		ArrayList<DevelopmentCard> temp = cards.get(card.getClass());
		
		if(temp == null){
			temp = new ArrayList<>();
			this.cards.put(card.getClass(), temp);
		}
		
		if(temp.size() > 6)
			return false;
		
		temp.add(card);
		return true;
	}
	
	
// End logic
// Start getters
	
	public <T extends DevelopmentCard> ArrayList<T> getCard (Class<T> cardClass){
		return (ArrayList<T>) this.cards.get(cardClass);
	}
	
// End getters
	
}
