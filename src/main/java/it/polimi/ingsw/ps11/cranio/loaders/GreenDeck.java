package it.polimi.ingsw.ps11.cranio.loaders;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;

public class GreenDeck {

	private ArrayList<GreenCard> mazzo;
	
	public GreenDeck() {
		mazzo = new ArrayList<GreenCard>();
	}
	
	public void add(GreenCard card){
		this.mazzo.add(card);
	}
	
	public GreenCard get(int index){
		return this.mazzo.get(index);
	}
}
