package it.polimi.ingsw.ps11.mvc.posView;

import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class TextualView {
	
	//private Game game;
	
	private String menuAzione = ""
			+ "0 : Visualizza il tuo status \n"
			+ "1 : Piazza familiare in una torre \n"
			+ "2 : Piazza familiare nel mercato \n"
			+ "3 : Piazza familiare nella zona produzione \n"
			+ "4 : Piazza familiare nella zona raccolta \n"
			+ "5 : Piazza familiare nel palazzo del consiglio \n"
			+ "p : Passa il tuo turno \n";
	
	private String input;
	
// Start Event 
	
	EventHandler<Event> printStatus = new EventHandler<>();
	EventHandler<Event> posizionaFamiliareTorre = new EventHandler<>();
	
	public EventHandler<Event> getPrintStatus() {
		return printStatus;
	}
	public EventHandler<Event> getPosizionaFamiliareTorre() {
		return posizionaFamiliareTorre;
	}
	
// End Event
	
	public void menu(){
		print(menuAzione);
		
		input = readInput();
		
		switch (input) {
		
		case "0":
			printStatus.invoke(new Event());
			break;
		
		case "1":	
			posizionaFamiliareTorre.invoke(new Event());
			break;
			
		case "p":
			break; 
			
		default: print("Comando non valido");
			break;
		}
	}
	
//___ output towers____
	
	public String scegliTorre(ArrayList<Tower> towers){
		printTowers(towers);
		System.out.println("Scegli la torre ");
		return readInput();
	}
	
	public void printTowers(ArrayList<Tower> towers){
		for(Tower tower: towers){
			printTower(tower);
		}
	}
	
	public void printTower(Tower tower){
		System.out.println("Tower: " + tower.getClass());
		for(Floor floor : tower.getFloors()){
			System.out.println(floor.getCard());
		}
	}
	
//___ end output towers _____
	

	public String scegliCarta(Tower tower){
		printTower(tower);
		print("Scegli quale carta prendere (da 1 a 4) :");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	
	public void printStatus(Player player){
		System.out.println("STATUS: \n" + player.toString());
	}
	
	
	public void print (String message){
		System.out.println(message);
	}

	private String readInput(){
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		return in;
	}
	
	
// ____________ START _______________
	
	public void start(){
		
		do {
			menu();
		} while(!this.input.equalsIgnoreCase("p"));
		
	}
}
