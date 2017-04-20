package test.main.da.cancellare.poi;

import event.*;
import it.polimi.cards.PurpleCard;
import it.polimi.cards.YellowCard;
import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.Dice;
import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.players.Player1;
import it.polimi.ingsw.ps11.zones.ProductionZone1;
import it.polimi.ingsw.resources.Stone;
import it.polimi.ingsw.resources.TestBonus;

public class TestMain {

	public static void main(String[] args) {
		
		Player1 player = new Player1();
		
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
		
		Stone st = new Stone();
		Observers tb = new TestBonus();
		st.observIncrementEvent(tb);
		st.increment(5);
		System.out.println(st.toString());
		
		System.out.println(player.toString()+"\nend of toString Player \n");
		
		
		
		
		
		

	}

}
