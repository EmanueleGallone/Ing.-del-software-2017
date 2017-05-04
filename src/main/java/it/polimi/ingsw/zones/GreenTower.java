package it.polimi.ingsw.zones;

import it.polimi.cards.GreenCard;
import it.polimi.ingsw.resources.Wood;

public class GreenTower extends Tower {
	
	public GreenTower(){
		super();
		cards.add(new GreenCard());
		cards.add(new GreenCard());
		cards.add(new GreenCard());
		cards.add(new GreenCard());
		instanceActionSpace();
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
	protected void instanceActionSpace(){
		//brutto questo metodo. si dovrebbe usare un ciclo.
		//bisogna che ogni torre instanzi questo metodo per conto suo -> abstract
		
		actionSpace.add(new ActionSpace(1)); //primo action Space
		actionSpace.add(new ActionSpace(3));
		actionSpace.add(new ActionSpace(new Wood(),1,5)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new Wood(),2,7)); //ultimo action Space dove posizionare il familiare
	}

	@Override
	public String toString() {
		return "TorreVerde [cards=" + cards + "]";
	}
	
	
	
}
