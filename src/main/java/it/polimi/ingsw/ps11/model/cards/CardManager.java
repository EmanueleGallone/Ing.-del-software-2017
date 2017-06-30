package it.polimi.ingsw.ps11.model.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h3>CardManager</h3>
 * <p> Classe container per le carte. Rappresenta una raccolta di carte. Ogni giocatore ne possiede uno.
 * </p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.cards.DevelopmentCard DevelopmentCard
 *
 */
public class CardManager implements Serializable {
	
	
	private final int MAX_CARD = 6;
	private HashMap<String , ArrayList<DevelopmentCard>> cards = new HashMap<>();
	private boolean limited = true;
	
	public CardManager() {
		
	}
	
	public CardManager(boolean limited) {
		setLimited(limited);
	}

	public CardManager(ArrayList<DevelopmentCard> cards) {
		for(DevelopmentCard card : cards){
			addCard(card);
		}
	}
	
	
// Start logic
	
	public <T extends DevelopmentCard> boolean addCard(T card){
		
		if(canAdd(card)){
			cards.get(card.getClass().toString()).add(card);
			return true;
		}
		
		return false;
	}
	
	public <T extends DevelopmentCard> boolean canAdd(T card){
		
		ArrayList<DevelopmentCard> temp = cards.get(card.getClass().toString());
		if(temp == null){
			temp = new ArrayList<>();
			this.cards.put(card.getClass().toString(), temp);
		}
		if(isLimited() && temp.size() >= MAX_CARD)
			return false;
		return true;
	}
	
	public boolean isLimited() {
		return limited;
	}
	
	public void setLimited(boolean limited) {
		this.limited = limited;
	}
	
// End logic
// Start getters
	
	public <T extends DevelopmentCard> ArrayList<T> getCardList (Class<T> cardClass){
		return (ArrayList<T>) this.cards.get(cardClass.toString()); //forse il casting va messo fuori nel chiamante del metodo; come per clone!
	}
	

	public <T extends DevelopmentCard> ArrayList<T> getCardList (String cardClass){ //necessario per bypassare il problema della serializzazione
		return (ArrayList<T>) this.cards.get(cardClass); 
	}
	
	
	public HashMap<String, ArrayList<DevelopmentCard>> getAllCards() {
		return (HashMap<String, ArrayList<DevelopmentCard>>) cards.clone();
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
		CardManager clone = new CardManager();
		
		for(ArrayList<DevelopmentCard> a : this.cards.values())
			for(DevelopmentCard card : a)
				clone.addCard(card.clone());	
		
		return clone;
	}
	
// End getters
	
	
	
}
