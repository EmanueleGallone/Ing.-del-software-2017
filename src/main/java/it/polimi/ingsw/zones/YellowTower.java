package it.polimi.ingsw.zones;

import gioco.da.console.DecoratedYellowCard;
import it.polimi.cards.YellowCard;
import it.polimi.ingsw.resources.MilitaryPoint;

public class YellowTower extends Tower {
	
	
	//firstPosition indico la zona dove mettere il familiare per prendere la carta nella posizione più bassa.
	//indico il value che deve possedere il family member. ancora da implementare
	
	public YellowTower(){
		super();
		cards.add(new DecoratedYellowCard(new YellowCard("carta decorata"))); //posizione 0 (più bassa)
		cards.add(new YellowCard());
		cards.add(new YellowCard());
		cards.add(new YellowCard()); //posizione 3 (più alta)
		instanceActionSpace();
	}
	
	public YellowTower(int period){
		//devo creare carte in base al periodo
		
		if(period == 1){
		cards.add(new DecoratedYellowCard(new YellowCard("carta decorata"))); //posizione 0 (più bassa)
		cards.add(new YellowCard());
		cards.add(new YellowCard());
		cards.add(new YellowCard()); //posizione 3 (più alta)
		}
		
		/*
		 * if period == 2 etc etc
		 */
	}
	
	@Override
	protected void instanceActionSpace(){
		//brutto questo metodo. si dovrebbe usare un ciclo.
		//bisogna che ogni torre instanzi questo metodo per conto suo -> abstract
		
		actionSpace.add(new ActionSpace(1)); //primo action Space
		actionSpace.add(new ActionSpace(3));
		actionSpace.add(new ActionSpace(new MilitaryPoint(),1,5)); //ATTENZIONE. va settato il tipo di risorsa da prendere (vedi tabellone)
		actionSpace.add(new ActionSpace(new MilitaryPoint(),2,7));
	}

	@Override
	public String toString() {
		return "TorreGialla [cards=" + cards.toString() + "]";
	}
	

}
