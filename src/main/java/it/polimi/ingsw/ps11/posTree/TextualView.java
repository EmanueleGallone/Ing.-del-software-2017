package it.polimi.ingsw.ps11.posTree;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.cranio.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.mvc.components.Console;
import it.polimi.ingsw.ps11.posTree.components.BoardView;
import it.polimi.ingsw.ps11.posTree.components.FloorView;
import it.polimi.ingsw.ps11.posTree.components.Panel;
import it.polimi.ingsw.ps11.posTree.components.TowerView;


public class TextualView{

	private Console console = new Console();
	private EventHandler<String> inputChangeEvent = new EventHandler<>();
	private TextualComponent document = new Panel();
	
	public TextualView() {

		BoardView boardView = new BoardView("board");
		
		boardView.add(createTower("greenTower",GreenTower.class));
		boardView.add(createTower("blueTower",BlueTower.class));
		boardView.add(createTower("yellowTower",YellowTower.class));
		boardView.add(createTower("purpleTower",PurpleTower.class));
		
		document.add(boardView);
	}
	
	private <T extends Tower> TextualComponent createTower(String name,Class<T> color){
		TowerView towerView = new TowerView(name);
		
		for(int i = 0; i<4 ; i++){
			towerView.add(new FloorView(name + " " + (i+1), color, i));
		}
		
		return towerView;
	}
	
	
	public String choseFamilyMember(){
		return console.read("Scegli un familyMember");
	}
	
	
	public void start(){
		System.out.println("View started");
		this.print();
		String input;
		while (!(input = console.read()).equals("quit")) {
			inputChangeEvent.invoke(input);
		}
		console.print("Quit game");
	}

	
	public void inputChangeEvent(EventListener<String> listener){
		this.inputChangeEvent.attach(listener);
	}

	public void print(){
		document.print();
	}
	
	public TextualComponent getDocument() {
		return document;
	}
}
