package it.polimi.ingsw.ps11.mvc.view.viewGenerica;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.mvc.view.ViewInterface;
import it.polimi.ingsw.ps11.mvc.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.TextualBoardView;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.TextualDocument;

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
