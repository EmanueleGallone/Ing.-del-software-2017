package pos.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardsManager {
	
	private static final int DEFAULT_MAX_CARDS = 6;
	
	private Map<Cards, ArrayList<Card>> cardList = new HashMap<>();;
	
//Start constructor
	
	public CardsManager() {
		for(Cards type: Cards.values()){
			cardList.put(type, new ArrayList<>());
		}
	}
	
//End constructor
//Start logics
	
	public boolean addCard(Card card){
		if (cardList.get(card.getType()).size() >= DEFAULT_MAX_CARDS ){
			return false;
		}
		this.setCard(card);
		return true;
	}
	
//End logics
// Start setters

	protected void setCard(Card card){
		cardList.get(card.getType()).add(card);
	}
	
//End setters
//Start getters
	
	public ArrayList<Card> getCardsByType(Cards type) {
		//Bisogna gestire la possibile presenza di dublicati
		return cardList.get(type);
	}
	public Card getCardByName(String name){
		for(ArrayList<Card> c : cardList.values()){
			for(Card card: c){
				if (card.getName() == name)
					return card;
			}
		}
		throw new IllegalArgumentException(); //Devo pensare se c'è una soluzione migliore...
	}
	
	public int getMaxCards() {
		return DEFAULT_MAX_CARDS;
	}

// End getters
	
}
