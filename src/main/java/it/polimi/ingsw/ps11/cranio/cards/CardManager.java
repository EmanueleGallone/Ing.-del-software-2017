package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;
import java.util.HashMap;


public class CardManager {
	
	
	private final int MAX_CARD = 6;
	private HashMap<String , ArrayList<DevelopmentCard>> cards = new HashMap<>();
	
	public CardManager(ArrayList<DevelopmentCard> cards) {
		for(DevelopmentCard card : cards){
			addCard(card);
		}
	}
	
	public CardManager() {
		
	}
	
	private CardManager(CardManager toCopy){
		//copy constructor;
		
		for(ArrayList<DevelopmentCard> a : toCopy.cards.values())
			for(DevelopmentCard card : a)
				this.addCard(card.clone());	
		
	}
	
	
// Start logic
	
	public <T extends DevelopmentCard> boolean addCard(T card){
		
		ArrayList<DevelopmentCard> temp = cards.get(card.getClass().toString());
		
		if(temp == null){
			temp = new ArrayList<>();
			this.cards.put(card.getClass().toString(), temp);
		}
		
		if(temp.size() <= MAX_CARD){
			temp.add(card);
			return true;
		}
		return false;
	}
	
	
// End logic
// Start getters
	
	public <T extends DevelopmentCard> ArrayList<T> getCardList (Class<T> cardClass){
		return (ArrayList<T>) this.cards.get(cardClass.toString()); //forse il casting va messo fuori nel chiamante del metodo; come per clone!
	}
	

	public <T extends DevelopmentCard> ArrayList<T> getCardList (String cardClass){ //necessario per bypassare il problema della serializzazione
		return (ArrayList<T>) this.cards.get(cardClass); 
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
	
	@Override
	public CardManager clone(){
		return new CardManager(this);
	}
	
// End getters
	
	
	
}
