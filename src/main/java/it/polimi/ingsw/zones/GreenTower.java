package it.polimi.ingsw.zones;

import it.polimi.cards.GreenCard;

public class GreenTower extends Tower {
	
	public GreenTower(){
		super();
		cards.add(new GreenCard());
		cards.add(new GreenCard());
		cards.add(new GreenCard());
		cards.add(new GreenCard());
	}
	
	public GreenTower(int period){
		super();
		//creo le carte in base al periodo.
		
		if(period == 1){
			
			cards.add(new GreenCard());
			cards.add(new GreenCard());
			cards.add(new GreenCard());
			cards.add(new GreenCard());
		}
		
		//if period == 2 etc etc

	}

	@Override
	public String toString() {
		return "TorreVerde [cards=" + cards + "]";
	}
	
	
	
}
