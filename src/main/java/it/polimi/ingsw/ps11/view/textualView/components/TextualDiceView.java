package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.DiceView;

public class TextualDiceView extends DiceView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.println("Dices");
		console.print("Black: " + dices.getBlackDice().getValue() + "\t White " + dices.getWhiteDice().getValue() +
				"\t Orange: " + dices.getOrangeDice().getValue()
				);
		console.print("\n");
	}

}
