package it.polimi.ingsw.ps11.mvc.view;

import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.events.Event;

public class TextualView {
	
	
	String menu = "1 : Stampa status player corrente \n";
	Interpreter interpreter = new Interpreter();
	
	
	private class Interpreter{
		
		public void interpreta(String input){
			switch (input) {
			case "1":
				stampaStatus.invoke(new Event());
				break;

			default: print("Comando non valido");
				break;
			}
		}
	}

	
	EventHandler<Event> stampaStatus = new EventHandler<>();
	
	public void addStampaPlayerListener(EventListener<Event> listener){
		stampaStatus.attach(listener);
	}
	
	public void stampaPlayer(Player player){
		//print(player.getPlayerName());
	}
	
	public void start(){
		print("Game started");
		print(menu);
		String input;
		while(!(input = readInput()).equals("quit")){
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
