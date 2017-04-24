package it.polimi.ingsw.zones;

import java.util.ArrayList;

import gioco.da.console.DecoratedYellowCard;
import it.polimi.cards.DevelopmentCard;
import it.polimi.cards.YellowCard;

public class YellowTower extends Tower {
	private int fourthPosition = 7;
	private int thirdPosition = 5;
	private int secondPosition = 3;
	private int firstPosition = 1;
	
	//firstPosition indico la zona dove mettere il familiare per prendere la carta nella posizione più bassa.
	//indico il value che deve possedere il family member. ancora da implementare
	
	public YellowTower(){
		super();
		cards.add(new DecoratedYellowCard(new YellowCard("carta decorata"))); //posizione 0 (più bassa)
		cards.add(new YellowCard());
		cards.add(new YellowCard());
		cards.add(new YellowCard()); //posizione 3 (più alta)
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
	public String toString() {
		return "TorreGialla [cards=" + cards.toString() + "]";
	}
	
	public DevelopmentCard getCard(int number){
		return cards.get(number);
	}
	
	public void removeCard(int position){
		cards.set(position,null);
	}

}
