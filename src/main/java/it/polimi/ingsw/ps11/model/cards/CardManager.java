package it.polimi.ingsw.ps11.model.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;

/**
 * <h3>CardManager</h3>
 * <p> Classe manager per le <code>DevelopmentCard</code>. Associa ad ogni tipo di carta un arrayList contenente le carte del giocatore 
 * appartenenti a quel dato tipo. Può imporre un limite di 6 carte per ogni tipoo di carta. Ogni giocatore ne possiede uno.</p> 
 * <p>Il costruttore accetta: boolean (indica se è presente il limite di carte), array di development card (distribuisce le carte
 * nel CardManager).</p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.cards.DevelopmentCard DevelopmentCard
 */
@SuppressWarnings("serial")
public class CardManager implements Serializable, Iterable<ArrayList<DevelopmentCard>> {
	
	
	private final int MAX_CARD = 6;
	private HashMap<String , ArrayList<DevelopmentCard>> cards = new HashMap<>();
	private HashMap<String, DevelopmentCard> tiles = new HashMap<>();
	private ArrayList<LeaderCard> leaderCards = new ArrayList<>();
	
	private boolean limited = true;
	
	public CardManager() {
		
	}
	/**<h3> CardManager(boolean) </h3>
	 * <p> Costruttore per CardManager che impone o mone un limite superiore al numero di carte per ogni tipo di carta </p>
	 */
	public CardManager(boolean limited) {
		setLimited(limited);
	}
	
	
// Start logic
	/**<h3> <T extends DevelopmentCard> boolean addCard(T)</h3>
	 * <p> Aggiunge una carta al mazzo relativo. Ritorna true se è stata aggiunta, false altrimenti. </p>
	 */
	public <T extends DevelopmentCard> boolean addCard(T card){
		
		if(canAdd(card)){
			cards.get(card.getId()).add(card);
			return true;
		}
		
		return false;
	}
	
	public void addCard(LeaderCard card){
		//va opportunamente limitato il numero di leader cards
		leaderCards.add(card);
		
	}
	
	/**<h3> boolean canAdd(T)</h3>
	 * <p> Controlla che il mazzo corrispondente ad una carta non abbia già il numero massimo di elementi. </p>
	 * @return true se il limite non è ancora stato raggiunto, false altrimenti
	 */
	public <T extends DevelopmentCard> boolean canAdd(T card){
		
		ArrayList<DevelopmentCard> temp = cards.get(card.getId());
		if(temp == null){
			temp = new ArrayList<>();
			this.cards.put(card.getId(), temp);
		}
		if(isLimited() && temp.size() >= MAX_CARD)
			return false;
		return true;
	}
	
	public void setTiles(ArrayList<DevelopmentCard> tiles) {
		for(DevelopmentCard tile : tiles){
			this.tiles.put(tile.getId(), tile);
		}
	}
	
	public String getTiles() {
		for(DevelopmentCard tile : tiles.values())
			return tile.getName();
		return "BLANK";
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
	
	public void resetLeaderCard(){
		for(LeaderCard card : leaderCards){
			card.setActivated(false);
		}
	}
	
// End logic
// Start getters
	

	@SuppressWarnings("unchecked")
	public ArrayList<DevelopmentCard> getCardList (String cardId, boolean all){
		ArrayList<DevelopmentCard> cards = this.cards.get(cardId);
		if(cards == null)
			cards = new ArrayList<>();
		else {
			cards = (ArrayList<DevelopmentCard>) cards.clone();
		}
		DevelopmentCard tile = tiles.get(cardId);
		if(tile!=null)
			cards.add(tiles.get(cardId));
		return cards;
	}
	
	public ArrayList<DevelopmentCard> getCardList (String cardId){
		ArrayList<DevelopmentCard> cards = this.cards.get(cardId);
		if(cards == null)
			cards = new ArrayList<>();
		return cards;
	}
	
	public ArrayList<LeaderCard> getLeaderCards() {
		return leaderCards;
	}
	
	public LeaderCard getLeaderCard(String cardName) throws IllegalArgumentException{
		for(LeaderCard card : leaderCards){
			if(card.getName().equals(cardName))
				return card;
		}
		throw new IllegalArgumentException();
	}
	
	public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
		this.leaderCards = leaderCards;
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
	@Override
	public Iterator<ArrayList<DevelopmentCard>> iterator() {
		return cards.values().iterator();
	}
	
	public int getMaxCards(){
		return MAX_CARD;
	}
	
}
