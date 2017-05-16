package it.polimi.ingsw.ps11.cranio.cards;

import java.util.ArrayList;
import java.util.Iterator;

import javax.print.attribute.Size2DSyntax;

public class Deck<CARD_TYPE> implements Iterable<CARD_TYPE> {
	
	private final static int DEFAULT_MAXSIZE = 6;
	private int maxSize;
	
	private ArrayList<CARD_TYPE> cards = new ArrayList<CARD_TYPE>();
	
	
	public Deck() {
		this(DEFAULT_MAXSIZE);
	}
	
	public Deck(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public boolean add(CARD_TYPE card) {
		if (cards.size() < maxSize){
			cards.add(card);
			return true;
		}
		return false;
	}
	
	public int size(){
		return this.cards.size();
	}
	
	public Iterator<CARD_TYPE> iterator() {
		return cards.iterator();
	}

}
