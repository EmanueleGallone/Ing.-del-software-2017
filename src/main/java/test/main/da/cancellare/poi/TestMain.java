package test.main.da.cancellare.poi;

import it.polimi.cards.PurpleCard;
import it.polimi.cards.YellowCard;
import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.Dice;
import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.players.Player1;
import it.polimi.ingsw.ps11.zones.ProductionZone1;

public class TestMain {

	public static void main(String[] args) {
		
		//funziona! ovviamente da migliorare. ema
		Player1 player = new Player1();
		
		ProductionZone1 production = new ProductionZone1();
		
		Dice blackdice = new BlackDice();
		blackdice.rollDice();
		
		PersonalBoard reference = player.getPersonalBoard();
		/*
		try { //testing per l'aggiunta di carte. Sembra tutto ok. Da migliorare l'output su console, magari rendendolo un po' più leggibile. ema
			for(int i = 0;i<6;i++){
				reference.addDevelopmentCard(new YellowCard());
				reference.addDevelopmentCard(new PurpleCard());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println(player.toString()+"\nfine toString Player \n");
		
		//testing the production zone : funziona. ema
		production.activate(reference);
		
		System.out.println(reference.toString());
		
		/*
		//test BlackDice roll: per fortuna funziona (se non riuscissi ad implementare neanche un dado, allora...). ema
		System.out.println("\n"+blackdice.toString());
		*/

	}

}
