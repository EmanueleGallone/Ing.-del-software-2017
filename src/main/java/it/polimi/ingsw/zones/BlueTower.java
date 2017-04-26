package it.polimi.ingsw.zones;

import it.polimi.cards.BlueCard;

public class BlueTower extends Tower {
	
	public BlueTower(){
		super();
		cards.add(new BlueCard());
		cards.add(new BlueCard());
		cards.add(new BlueCard());
		cards.add(new BlueCard());
	}
	
	public BlueTower(int period){
		super();
		//creo le carte in base al periodo.
		
		if(period == 1){
			
			cards.add(new BlueCard());
			cards.add(new BlueCard());
			cards.add(new BlueCard());
			cards.add(new BlueCard());
		}
		
		//if period == 2 etc etc

	}

	@Override
	public String toString() {
		return "TorreBlu [cards=" + cards + "]";
	}

}
