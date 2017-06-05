package it.polimi.ingsw.ps11.mvc.view.textualView.tree;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.mvc.view.textualView.Console;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.BoardView;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.Document;


public class TextualView extends View {

	private Console console = new Console();
	private EventHandler<String> inputChangeEvent = new EventHandler<>();
	private Document document = new Document();
	
	public TextualView() {

		BoardView boardView = new BoardView("board");
		
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
		System.out.println("View started");
		String input;
		while (!(input = console.read()).equals("quit")) {
			inputChangeEvent.invoke(input);
		}
		console.print("\nQuit game\n");
	}
	
	public void inputChangeEvent(EventListener<String> listener){
		this.inputChangeEvent.attach(listener);
	}

	public void print(){
		document.print();
	}
	
	public Document getDocument() {
		return document;
	}

	@Override
	public void out(String message) {
		console.print(message);
	}
	
	// UPDATE ____________________________-
	

	@Override
	public void update(Game game) {
		super.update(game);
	}

	@Override
	public void update(Board board) {
		BoardView boardView = (BoardView) document.getByClass(BoardView.class);
		System.out.println("daje");
	}

	@Override
	public void update(Player player) {
		// TODO Auto-generated method stub
		
	}
	
}
