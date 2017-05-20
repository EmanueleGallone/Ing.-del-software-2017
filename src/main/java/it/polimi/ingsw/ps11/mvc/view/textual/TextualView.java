package it.polimi.ingsw.ps11.mvc.view.textual;

import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.events.Event;

public class TextualView {
	
	GameView game = new GameView();
	
	String menuAzione = ""
			+ "0 : Visualizza il tuo status \n"
			+ "1 : Piazza familiare in una torre \n"
			+ "2 : Piazza familiare nel mercato \n"
			+ "3 : Piazza familiare nella zona produzione \n"
			+ "4 : Piazza familiare nella zona raccolta \n"
			+ "5 : Piazza familiare nel palazzo del consiglio \n"
			+ "p : Passa il tuo turno \n"
			+ "e : Esci \n";
	
	Interpreter interpreter = new Interpreter();
	
	
	private class Interpreter{
		
		public void interpreta(String input){
			switch (input) {
			
			case "0":
				game.printPlayer();
				break;
			
			case "1":
				scegliTorre();
				break;
				
			default: print("Comando non valido");
				break;
			}
		}
	}
	
	public GameView getGame() {
		return game;
	}
	
	public void scegliTorre(){
		print("Le torri e i piani vanno da 1 a 4. Premi una coppia x y, per scegliere la torre x e il piano y \n"
				+ "(Es: 1 3 significa torre 1 piano 3)");
		String in = readInput();
		Floor floor = game.getFloor(in.charAt(0), in.charAt(2));
		print("Seleziona family member, premi un numero da 1 a 4");
		FamilyMember familyMember = game.getFamilyMember(Integer.parseInt(readInput()));
		
	}
	
	public void start(){
		print("Game started");
		print(menuAzione);
		game.printTowers();
		String input;
		while(!(input = readInput()).equals("e")){
			interpreter.interpreta(input);
		}
		print("Game closed");
	}
	
	private String readInput(){
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		return in;
	}
	
	public void print (String message){
		System.out.println(message);
	}
	
}
