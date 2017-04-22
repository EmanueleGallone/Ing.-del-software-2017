package test.main.da.cancellare.poi;

import java.util.ArrayList;

import event.*;
import event.increment.IncrementObserver;
import event.stringChange.StringChangeObserver;
import it.polimi.ingsw.dices.BlackDice;
import it.polimi.ingsw.dices.Dice;
import it.polimi.ingsw.player.gadgets.PersonalBoard;
import it.polimi.ingsw.players.Player1;
import it.polimi.ingsw.ps11.zones.ProductionZone1;
import it.polimi.ingsw.resources.Resource;
import it.polimi.ingsw.resources.Stone;

public class TestMain {

	public static void main(String[] args) {
		
		Resource resource = new Resource();
		//IncrementObserver ob = new IncrementObserver();
		StringChangeObserver observer = new StringChangeObserver();
		
		resource.getStringChangeEvent().attach(observer);
		resource.changeString("bla bla");
	}
	
	public void stampa(String message){
		System.out.println(message);
	}

}
