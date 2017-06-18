package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;

public class TextualPlayerView extends PlayerView{

	public TextualPlayerView() {
		resourceView = new TextualResourceView();
		personalBoard = new TextualPersonalBoardView();
	}
	
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		console.print(player.getName() + " Resources: ");
		resourceView.print();
		console.println("Cards: ");
		personalBoard.print();
	}

}
