package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;

public class TextualDiceView extends DiceView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println("Dices");
//		console.print("Black: " + dices.getDice(BlackDice.class).getValue() + "\t White " + dices.getDice(WhiteDice.class).getValue() +
//				"\t Orange: " + dices.getDice(OrangeDice.class).getValue()
//				);
//		
		
		for(Dice dice : dices){
			console.print(dice.getName() + ": " + dice.getValue() +"\t");
		}
		console.print("\n");
	}

}
