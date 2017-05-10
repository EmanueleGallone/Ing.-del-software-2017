package gioco.da.console.zones;

import gioco.da.console.cards.BlueCard;
import gioco.da.console.resources.Stone;

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
		
		actionSpace.add(new ActionSpace(1)); //primo action Space
		actionSpace.add(new ActionSpace(3));
		actionSpace.add(new ActionSpace(new Stone(),1,5)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new Stone(),2,7)); //ultimo action space
	}

	@Override
	public String toString() {
		return "TorreBlu [cards=" + cards + "]";
	}

}