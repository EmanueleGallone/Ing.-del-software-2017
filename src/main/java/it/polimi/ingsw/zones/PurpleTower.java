package it.polimi.ingsw.zones;

import it.polimi.cards.PurpleCard;
import it.polimi.ingsw.resources.Coin;

public class PurpleTower extends Tower {
	
	public PurpleTower(){
		super();
		cards.add(new PurpleCard()); // posiziono le carte (bisogna capire come implementare una funzione per caricarle da file
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
		
		actionSpace.add(new ActionSpace(1)); //primo action Space
		actionSpace.add(new ActionSpace(3));
		actionSpace.add(new ActionSpace(new Coin(),1,5)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new Coin(),2,7));
	}

	@Override
	public String toString() {
		return "PurpleTower [actionSpace=" + actionSpace + ", cards=" + cards + "]";
	}

}
