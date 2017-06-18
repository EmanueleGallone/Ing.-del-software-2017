package it.polimi.ingsw.ps11.view.textualView;

import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class TextualView extends View {
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
	}

	@Override
	public void print() {
		boardView.print();
		you.print();
	}
	
}
