package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;
import java.util.Iterator;

public class Deck<CARD_TYPE> implements Iterable<CARD_TYPE> {
	private int maxSize;
	
	private ArrayList<CARD_TYPE> cards = new ArrayList<CARD_TYPE>();
	
	public Deck(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public boolean add(CARD_TYPE card) {
		if (maxSize < cards.size()){
			cards.add(card);
			return true;
		}
		return false;
	}
	
	
	public Iterator<CARD_TYPE> iterator() {
		return cards.iterator();
	}
	

}
