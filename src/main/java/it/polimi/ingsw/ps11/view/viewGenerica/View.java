package it.polimi.ingsw.ps11.view.viewGenerica;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.ViewInterface;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.tree.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.tree.components.TextualDocument;

public abstract class View extends Thread implements ViewInterface {
	
	private Game game;

	private TextualConsole console;
	private EventHandler<String> inputChangeEvent = new EventHandler<>();
	private TextualDocument document = new TextualDocument();
	
	public View() {

	}
	
	@Override
	public void run() {
		
		console.println("View started");
		
		String input;
		while (!(input = console.read()).equals("quit")) {
			inputChangeEvent.invoke(input);
		}
		console.println("\nQuit game\n");
	}
	
	public void inputChangeEvent(EventListener<String> listener){
		this.inputChangeEvent.attach(listener);
	}

	public void print(){
		document.print();
	}
	
	public TextualDocument getDocument() {
		return document;
	}

	@Override
	public void out(String message) {
		console.println(message);
	}
	
	// UPDATE ____________________________-
	

	@Override
	public void update(Game game) {
		update(game.getBoard());
	}

	@Override
	public void update(Board board) {
		TextualBoardView boardView = document.getByClass(TextualBoardView.class);
		
	}

	@Override
	public void update(Player player) {
		// TODO Auto-generated method stub
		
	}
}
