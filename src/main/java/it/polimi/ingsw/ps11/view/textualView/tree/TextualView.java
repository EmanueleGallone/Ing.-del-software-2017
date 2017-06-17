package it.polimi.ingsw.ps11.view.textualView.tree;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.textualView.tree.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.tree.components.TextualDocument;
import it.polimi.ingsw.ps11.view.viewGenerica.View;


public class TextualView extends View {

	private TextualConsole console = new TextualConsole();
	private EventHandler<String> inputChangeEvent = new EventHandler<>();
	private TextualDocument document = new TextualDocument();
	
	public TextualView() {

		TextualBoardView boardView = new TextualBoardView("board");
		
		/*boardView.add(createTower("greenTower",GreenTower.class));
		boardView.add(createTower("blueTower",BlueTower.class));
		boardView.add(createTower("yellowTower",YellowTower.class));
		boardView.add(createTower("purpleTower",PurpleTower.class));
		*/
		document.add(boardView);
	}
	
	/*
	private <T extends Tower> TextualComponent createTower(String name,Class<T> color){
		TowerView towerView = new TowerView(name);
		
		for(int i = 0; i<4 ; i++){
			towerView.add(new FloorView(name + " " + (i+1), color, i));
		}
		
		return towerView;
	}
	*/
	
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
		super.update(game);
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