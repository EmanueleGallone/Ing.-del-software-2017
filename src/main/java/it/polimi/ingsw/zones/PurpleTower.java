package it.polimi.ingsw.zones;

import it.polimi.cards.PurpleCard;
import it.polimi.ingsw.resources.Coin;

public class PurpleTower extends Tower {
	
	public PurpleTower(){
		super();
		cards.add(new PurpleCard());
		cards.add(new PurpleCard());
		cards.add(new PurpleCard());
		cards.add(new PurpleCard());
		instanceActionSpace(); //instanzio gli spazi azione
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
	protected void instanceActionSpace(){
		//brutto questo metodo. si dovrebbe usare un ciclo.
		//bisogna che ogni torre instanzi questo metodo per conto suo -> abstract
		
		actionSpace.add(new ActionSpace()); //primo action Space
		actionSpace.add(new ActionSpace());
		actionSpace.add(new ActionSpace(new Coin(),1)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new Coin(),2));
	}

	@Override
	public String toString() {
		return "TorreViola [cards=" + cards + "]";
	}

}
