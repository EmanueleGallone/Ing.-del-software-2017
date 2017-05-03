package it.polimi.ingsw.zones;

import it.polimi.cards.BlueCard;
import it.polimi.ingsw.resources.Stone;

public class BlueTower extends Tower {
	
	public BlueTower(){
		super();
		cards.add(new BlueCard());
		cards.add(new BlueCard());
		cards.add(new BlueCard());
		cards.add(new BlueCard());
		instanceActionSpace();
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
	protected void instanceActionSpace(){
		//brutto questo metodo. si dovrebbe usare un ciclo.
		//bisogna che ogni torre instanzi questo metodo per conto suo -> abstract
		
		actionSpace.add(new ActionSpace()); //primo action Space
		actionSpace.add(new ActionSpace());
		actionSpace.add(new ActionSpace(new Stone(),1)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new Stone(),2)); //ultimo action space
	}

	@Override
	public String toString() {
		return "TorreBlu [cards=" + cards + "]";
	}

}
