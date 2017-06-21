package it.polimi.ingsw.ps11.view.textualView;

import it.polimi.ingsw.ps11.view.events.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
import it.polimi.ingsw.ps11.view.viewGenerica.components.FloorView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.TowerView;

public class TextualView extends View {
	
	private String instructions = ""
			+ "\nWrite: \n"
		//	+ " tower x   -> To select the x tower \n"
			+ " tower x n -> To select the n floor on the x tower \n"
			+ " pass      -> To end your turn"
			+ " q         -> To quit the game";
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		console = new TextualConsole();
	}

	@Override
	public void print() {
		boardView.print();
		you.print();
		console.println(instructions);
	}

	@Override
	public void run() {
		this.print();
		String input;
		while (!(input = console.read()).equals("q")){
			selectComponent(input);
		}
	}
	
	public void selectComponent(String input){
		//Da rivedere, non volevo perderci tempo
		input = input.trim();
		String[] parts = input.split(" ");
		if (parts[0].equals("tower")){
			try{
				TowerView towerView = boardView.getTowers().get(Integer.parseInt(parts[1])-1);
				try {
					FloorView floorView = towerView.getFloors().get(Integer.parseInt(parts[2])-1);
					FloorSelectedEvent event = new FloorSelectedEvent(floorView.getTower(), floorView.getWhichFloor());
					events.invoke(FloorSelectedEvent.class, event);
				} catch (Exception e) {
					console.printError("L'indice del piano non e' valido");
				}
				
			}
			catch (Exception e) {
				console.printError("L'indice della torre non e' valido");
			}
			
		}
	}
	
}
