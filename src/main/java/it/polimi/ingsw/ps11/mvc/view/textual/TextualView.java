package it.polimi.ingsw.ps11.mvc.view.textual;

import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.cranio.events.Event;

public class TextualView {
	
	private Game game;
	
	private String menuAzione = ""
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
				printStatus(game.getPlayerCorrente());
				break;
			
			case "1":
				scegliTorre();
				break;
				
			default: print("Comando non valido");
				break;
			}
		}
	}
	
	public void printMenu(){
		print(menuAzione);
	}
	
	public void scegliTorre(){
		printTowers();
		
		print("Scegli la torre: 1 torre gialla\n" 
				+ "2 : torre blu\n"
				+ "3 : torre verde\n"
				+ "4 : torre viola\n");
		
		String torre = readInput();//dovrei passare la torre e la carta scelta, no?
		
		scegliCarta(); //faccio scegliere la carta. Ora dovrei delegare al controller/model!
		
		
	}
	
	public void start(){
		print("Game started");
		print(menuAzione);
		
		printTowers();
		
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
	
	
	public void update(Game game){
		this.game = game;
	}
	
	
	public void printStatus(Player player){
		System.out.println("STATUS: \n" + player.toString());
	}
	
	public void printTowers(){
		//molto ignorantemente
		game.getBoard().getTempTowers().get(GreenTower.class).toString();
		game.getBoard().getTempTowers().get(PurpleTower.class).toString();
		game.getBoard().getTempTowers().get(YellowTower.class).toString();
		game.getBoard().getTempTowers().get(BlueTower.class).toString();
	}
	
	public String scegliCarta(){
		Scanner in = new Scanner(System.in);
		System.out.println("Scegli quale carta prendere (da 1 a 4) : ");
		return in.nextLine();
	}
	
	public void printBoard(){
		System.out.println("MERCATO: \n" + game.getBoard().toString());
	}
	
	public String printFamilyChoice(){
		Scanner in = new Scanner(System.in);
		System.out.println("inserisci quale familiare vuoi usare: \n" 
		+ "1 : Familiare Nero\n" 
		+ "2: Familiare Bianco\n"
		+ "3: Familiare Arancione\n"
		+ "4: Familiare Neutro");
		return in.nextLine();
		
	}
	
}
