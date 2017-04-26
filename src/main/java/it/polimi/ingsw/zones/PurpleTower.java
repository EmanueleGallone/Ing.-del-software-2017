package it.polimi.ingsw.zones;

import it.polimi.cards.PurpleCard;

public class PurpleTower extends Tower {
	
	public PurpleTower(){
		super();
		cards.add(new PurpleCard());
		cards.add(new PurpleCard());
		cards.add(new PurpleCard());
		cards.add(new PurpleCard());
	}
	
	public PurpleTower(int period){
		super();
		//creo le carte in base al periodo.
		
		if(period == 1){
			
			cards.add(new PurpleCard());
			cards.add(new PurpleCard());
			cards.add(new PurpleCard());
			cards.add(new PurpleCard());
		}
		
		//etc etc

	}

	@Override
	public String toString() {
		return "TorreViola [cards=" + cards + "]";
	}

}
