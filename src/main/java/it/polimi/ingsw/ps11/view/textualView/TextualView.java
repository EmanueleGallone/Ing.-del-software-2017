package it.polimi.ingsw.ps11.view.textualView;

import it.polimi.ingsw.ps11.view.events.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.textualView.components.TextualBoardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualPlayerView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;
/**
 * <h3>TextualView</h3>
 * <p> 
 * Classe rappresentante la CLI. Da qui l'utente si interfaccia con il gioco.
 * </p>
 */
public class TextualView extends View {
	
	private String instructions = "\n1: Print your Status" 
			+ "\n2: Place Family member in Towers"
			+ "\n3: Place Family member in Production"
			+ "\n4: Place Family member in harvest"
			+ "\n5: Place Family member in Council Palace"
			+ "\n6: Pass your turn"
			+ "\nq: Quit the game"; 
	
	private String towerChoice = "\n1: YellowTower"
			+ "\n2: BlueTower"
			+ "\n3: GreenTower"
			+ "\n4: PurpleTower"
			+ "\n0: Cancel"
			+ "\n";
	
	private String familyChoice = "Choose a Familiar: " 
			+ "\n1: White "
			+ "\n2: Orange"
			+ "\n3: Black"
			+ "\n4: Neutral"
			;
	
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
			console.println(instructions);
		}
	}
	
	public void selectComponent(String input){
		
		switch (input) {
		case "1":
			you.print();
			break;
		case "2":
			towerChoice();
			break;
			
		
			

		default:
			console.printError("Unknown command");
			break;
		}		
		
	}
	
	private void towerChoice(){
		console.print(towerChoice);
		String choice = console.read();
		
		switch (choice) {
		case "1":
			floorChoice(1);
			break;
		case "2":
			floorChoice(2);
			break;
		case "3":
			floorChoice(3);	
			break;
		case "4":
			floorChoice(4);
			break;
		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
	}
	
	private void floorChoice(int tower){
		console.println("(Presso 0 to Cancel)");
		console.print("Select the Floor : ");
		String whichFloor = console.read();
		FloorSelectedEvent event;
		
		switch (whichFloor) {
		case "1":
			event = new FloorSelectedEvent(tower, 1);
			break;
		case "2":
			event = new FloorSelectedEvent(tower, 2);
			break;
		case "3":
			event = new FloorSelectedEvent(tower, 3);
			break;
		case "4":
			event = new FloorSelectedEvent(tower, 4);
			break;

		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
		
	}
	
	private void productionChoice(){
		
	}
	
	private void familyChoice(){
		//la scelta nel familiare? dove la si mette? ad esempio in FloorSelectedEvent?
		console.print(familyChoice);
		String choice = console.read();
		
		switch (choice) {
		case "1":
			//lancia il FamilySelectedEvent?
			break;
		case "2":
			//lancia il FamilySelectedEvent?
			break;
		case "3":
			//lancia il FamilySelectedEvent?
			break;
		case "4":
			//lancia il FamilySelectedEvent?
			break;

		default:
			System.err.println("Unknown command.");
			break;
		}
		
		
	}
	
}
