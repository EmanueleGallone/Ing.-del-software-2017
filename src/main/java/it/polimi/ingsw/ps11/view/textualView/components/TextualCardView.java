package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.CardView;

public class TextualCardView extends CardView {

	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.print(card.getName() + " ");
	}

}
