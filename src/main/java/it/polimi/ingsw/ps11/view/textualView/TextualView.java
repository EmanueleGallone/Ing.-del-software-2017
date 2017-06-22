package it.polimi.ingsw.ps11.view.textualView;

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
	
	private String towerChoice = "\n1: GreenTower"
			+ "\n2: BlueTower"
			+ "\n3: YellowTower"
			+ "\n4: PurpleTower"
			+ "\n0: Cancel"
			+ "\n";
	
	private String familyChoice = "Choose a Familiar: " 
			+ "\n1: White "
			+ "\n2: Orange"
			+ "\n3: Black"
			+ "\n4: Neutral"
			+ "\n"
			;
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		console = new TextualConsole();
		
		//dovrei avere tutti i components nel caso definissi la select; oppure definire in cascata da boardView
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
		//se definissi la select, allora farei semplicemente ad esempio boardview.gettowerchoice.select()? dove towerchoice è un towerView
		switch (input) {
		case "1":
			you.print();
			break;
		case "2":
			towerChoice();
			break;
		case "3":
			productionChoice();
			break;
		case "4":
			harvestChoice();
			break;
		case "5":
			counsilChoice();
			break;
			
			
		//case passa turno	

		default:
			console.printError("Unknown command");
			break;
		}		
		
	}
	
	private void towerChoice(){
		//si segue per ora l'ordine con cui vengono caricate le torri, dal file
		console.print(towerChoice);
		String choice = console.read();
		
		switch (choice) {
		case "1": //blueTower
			boardView.getTowers().get(0).selected();
			//floorChoice(1);
			break;
		case "2": //greenTower
			boardView.getTowers().get(1).selected();
			//floorChoice(2);
			break;
		case "3": // yellowTower
			boardView.getTowers().get(2).selected();
			//floorChoice(3);	
			break;
		case "4": //PurpleTower
			boardView.getTowers().get(3).selected();
			//floorChoice(4);
			break;
		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
	}
	
	/*private void floorChoice(int tower){
	 * spostata all'interno di textualTowerView
		console.println("(Presso 0 to Cancel)");
		console.print("Select the Floor : ");
		String whichFloor = console.read();
		
		switch (whichFloor) {
		case "1":
			// new FloorSelectedEvent(tower, 1);
			break;
		case "2":
			// new FloorSelectedEvent(tower, 2);
			break;
		case "3":
			// new FloorSelectedEvent(tower, 3);
			break;
		case "4":
			// new FloorSelectedEvent(tower, 4);
			break;

		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
		
	}*/
	
	private void productionChoice(){
		console.print("Production Zone\n");
		familyChoice(); //scelta del familiare
		//lancio ProductionZoneSelect?
		
	}
	
	private void harvestChoice(){
		console.print("Harvest Zone\n");
		familyChoice(); //scelta del familiare
		//lancio ProductionZoneSelect?
		
	}
	
	private void familyChoice(){
		//la scelta nel familiare? dove la si mette? ad esempio in FloorSelectedEvent?
		console.print(familyChoice + "(Press 0 to Cancel the action)\n");
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
			
		case "0":
			return;

		default:
			System.err.println("Unknown command.");
			break;
		}
		
		
	}
	
	private void counsilChoice(){
		console.print("Council Palace");
		familyChoice();
		//lancia CouncilSelectedEvent
	}
	
}
