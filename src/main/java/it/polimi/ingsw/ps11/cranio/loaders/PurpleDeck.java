package it.polimi.ingsw.ps11.cranio.loaders;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.list.PurpleCard;

public class PurpleDeck {
	
	private ArrayList<PurpleCard> mazzo;
	
	public PurpleDeck() {
		mazzo = new ArrayList<PurpleCard>();
	}
	
	public void add(PurpleCard card){
		this.mazzo.add(card);
	}
	
	public PurpleCard get(int index){
		return this.mazzo.get(index);
	}

}
