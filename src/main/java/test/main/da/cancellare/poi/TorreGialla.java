package test.main.da.cancellare.poi;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.cards.YellowCard;

public class TorreGialla {
	private int fourthPosition = 7;
	private int thirdPosition = 5;
	private int secondPosition = 3;
	private int firstPosition = 1;
	
	//firstPosition indico la zona dove mettere il familiare per prendere la carta nella posizione più bassa. (indico il value in realtà)
	
	private ArrayList<YellowCard> cards = new ArrayList<>();
	private final int MAX_SLOT = 4;
	
	Iterator it = cards.iterator();
	
	public TorreGialla(){
		cards.add(new YellowCard()); //posizione 1 (più bassa)
		cards.add(new YellowCard());
		cards.add(new YellowCard());
		cards.add(new YellowCard()); //posizione 4 (più alta)
	}

	@Override
	public String toString() {
		return "TorreGialla [cards=" + cards.toString() + "]";
	}
	
	

}
