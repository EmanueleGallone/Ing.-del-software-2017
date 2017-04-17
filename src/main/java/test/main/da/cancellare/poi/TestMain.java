package test.main.da.cancellare.poi;

import it.polimi.cards.*;
import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.players.Player1;
import it.polimi.ingsw.dices.*;

public class TestMain {

	public static void main(String[] args) {
		
		//funziona! ovviamente da migliorare
		Player1 player = new Player1();
		Dice blackdice = new BlackDice();
		blackdice.rollDice();
		
		PersonalBoard reference = player.getPersonalBoard();
		try {
			for(int i = 0;i<6;i++){
				reference.addDevelopmentCard(new YellowCard());
				reference.addDevelopmentCard(new PurpleCard());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(reference.toString());
		
		//test BlackDice roll
		System.out.println("\n"+blackdice.toString());
		

	}

}
