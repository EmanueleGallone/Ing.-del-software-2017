package it.polimi.ingsw.ps11.cranio.loaders;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.list.YellowCard;

public class YellowDeck {
	
	private ArrayList<YellowCard> mazzo;
	
	public YellowDeck() {
		mazzo = new ArrayList<>();
	}
	
	public void add(YellowCard card){
		this.mazzo.add(card);
	}
	
	public YellowCard get(int index){
		return this.mazzo.get(index);
	}

}
