package it.polimi.ingsw.ps11.cranio.cards;

public class CardManager {
	private final int MAX_SIZE = 6;
	
	private Deck<PurpleCard> purpleDeck = new Deck<>(MAX_SIZE);
	private Deck<YellowCard> yellowDeck = new Deck<>(MAX_SIZE);
	private Deck<BlueCard> blueDeck = new Deck<>(MAX_SIZE);
	private Deck<GreenCard> greenDeck = new Deck<>(MAX_SIZE);
	
	
	
// Start logic
	
	
	public void deserializeCard(String serialized){
		
	}
	
	
	public void addBlueCard(BlueCard card) {
		blueDeck.add(card);		
	}
	
	public void addGreenCard(GreenCard card) {
		greenDeck.add(card);		
	}
	
	public void addPurpleCard(PurpleCard card){
		purpleDeck.add(card);		
	}
	
	public void addYellowCard(YellowCard card){
		yellowDeck.add(card);		
	}
	
// End logic
// Start getters
	
	public Deck<BlueCard> getBlueDeck() {
		return blueDeck;
	}
	public Deck<GreenCard> getGreenDeck() {
		return greenDeck;
	}
	public Deck<PurpleCard> getPurpleDeck() {
		return purpleDeck;
	}
	public Deck<YellowCard> getYellowDeck() {
		return yellowDeck;
	}
	
	
	public int getMAX_SIZE() {
		return MAX_SIZE;
	}
	
// End getters
	
}
