package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;
import java.util.HashMap;


public class CardManager {
	
	private HashMap<String , ArrayList<DevelopmentCard>> cards = new HashMap<>();
	
	public CardManager(ArrayList<DevelopmentCard> cards) {
		for(DevelopmentCard card : cards){
			addCard(card);
		}
	}
	
	public CardManager() {
		
	}
	
	
// Start logic
	
	public <T extends DevelopmentCard> boolean addCard(T card){
		
		ArrayList<DevelopmentCard> temp = cards.get(card.getClass().toString());
		
		if(temp == null){
			temp = new ArrayList<>();
			this.cards.put(card.getClass().toString(), temp);
		}
		
		if(temp.size() > 6)
			return false;
		
		temp.add(card);
		return true;
	}
	
	
// End logic
// Start getters
	
	public <T extends DevelopmentCard> ArrayList<T> getCardList (Class<T> cardClass){
		return (ArrayList<T>) this.cards.get(cardClass.toString());
	}

	@Override
	public String toString() {
		String string = "";
		for(ArrayList<DevelopmentCard> deck : cards.values()){
			for(DevelopmentCard card : deck){
				string = string + card.toString() + '\n';
			}
		}
		return string;
	}
	
// End getters
	
	
	
}
