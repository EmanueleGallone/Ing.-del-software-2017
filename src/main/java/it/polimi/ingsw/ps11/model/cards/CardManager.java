package it.polimi.ingsw.ps11.model.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h3>CardManager</h3>
 * <p> Classe manager per le <code>DevelopmentCard</code>. Associa ad ogni tipo di carta l'elenco delle carte del giocatore appartenenti alla data classe. Ogni giocatore ne possiede uno. </p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.cards.DevelopmentCard DevelopmentCard
 */
public class CardManager implements Serializable {
	
	
	private final int MAX_CARD = 6;
	private HashMap<String , ArrayList<DevelopmentCard>> cards = new HashMap<>();
	private boolean limited = true;
	
	public CardManager() {
		
	}
	/**<h3> CardManager(boolean) </h3>
	 * <p> Impone un limite di 6 carte per tipo </p>
	 */
	public CardManager(boolean limited) {
		setLimited(limited);
	}

	public CardManager(ArrayList<DevelopmentCard> cards) {
		for(DevelopmentCard card : cards){
			addCard(card);
		}
	}
	
	
// Start logic
	/**<h3> <T extends DevelopmentCard> boolean addCard(T)</h3>
	 * <p> Aggiunge una carta al mazzo relativo. Ritorna true se è stata aggiunta, false altrimenti. </p>
	 */
	public <T extends DevelopmentCard> boolean addCard(T card){
		
		if(canAdd(card)){
			cards.get(card.getClass().toString()).add(card);
			return true;
		}
		
		return false;
	}
	
	/**<h3> boolean canAdd(T)</h3>
	 * <p> Controlla che il mazzo corrispondente ad una carta non abbia già il numero massimo di elementi. </p>
	 * @return true se il limite non è ancora stato raggiunto, false altrimenti
	 */
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
	
	/**<h3> boolean isLimited() </h3>
	 * <p> Indica se il mazzo ha limite nel numero di carte. </p>
	 */
	public boolean isLimited() {
		return limited;
	}
	
	public void setLimited(boolean limited) {
		this.limited = limited;
	}
	
// End logic
// Start getters
	

	public <T extends DevelopmentCard> ArrayList<T> getCardList (Class<T> cardClass){
		return (ArrayList<T>) getCardList(cardClass.toString()); 
	}
	

	public ArrayList<DevelopmentCard> getCardList (String cardClass){
		ArrayList<DevelopmentCard> cards = this.cards.get(cardClass);
		if(cards == null)
			cards = new ArrayList<>();
		return cards;
	}
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, ArrayList<DevelopmentCard>> getAllCards() {
		return (HashMap<String, ArrayList<DevelopmentCard>>) cards.clone();
	}

	/**<h3> String toString() </h3>
	 * <p> Per ogni carta del mazzo stampa : TIPOCARTA [DEFAULT_VALUE= , activeValue= ]\n </p>
	 */
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
	
}
