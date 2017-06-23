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
	
	public TextualView() {
		you = new TextualPlayerView();
		boardView = new TextualBoardView();
		console = new TextualConsole();
		
		//dovrei avere tutti i components nel caso definissi la select; oppure definire in cascata da boardView
	}

	@Override
	public void print() {
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
		case "3":
			//productionChoice();
			break;
		case "4":
			//harvestChoice();
			break;
		case "5":
			//counsilChoice();
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
		case "1": //GreenTower
			//il numero nel Selected rappresenta la torre scelta. se si scegliesse di tornare sulla map, bisogna cambiare su Towerview il parametro di selected()
			boardView.getTowerViews().get(0).selected();
			
			break;
		case "2": //BlueTower
			boardView.getTowerViews().get(1).selected();

			break;
		case "3": // yellowTower
			boardView.getTowerViews().get(2).selected();

			break;
		case "4": //PurpleTower
			boardView.getTowerViews().get(3).selected();

			break;
		case "0":
			return;
			
		default:
			console.printError("Unknown command");
			break;
		}
	}
	
	
	
	
	
	
}
