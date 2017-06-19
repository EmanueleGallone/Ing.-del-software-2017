package it.polimi.ingsw.ps11.view.textualView;

import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class TextualView extends View {
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		console = new TextualConsole();
	}

	@Override
	public void print() {
		boardView.print();
		you.print();
	}

	@Override
	public void run() {
		String input;
		while (!(input = console.read()).equals("q")){
			selectComponent(input);
		}
	}
	
	public void selectComponent(String input){
		
	}
	
}
