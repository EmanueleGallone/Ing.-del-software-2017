package test.main.da.cancellare.poi;

import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.Dice;

public class Board {
	private TorreGialla torreGialla;
	private BlackDice blackDice;
	
	public Board(){
		torreGialla = new TorreGialla();
		blackDice = new BlackDice();
	}

	@Override
	public String toString() {
		return "Board [torreGialla=" + torreGialla + "\n\nBlackDice="+ blackDice + "]";
	}
	
	public BlackDice getBlackDice(){
		return blackDice;
	}

	
}
