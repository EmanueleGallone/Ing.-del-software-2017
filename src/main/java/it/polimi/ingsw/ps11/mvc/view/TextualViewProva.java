package it.polimi.ingsw.ps11.mvc.view;

import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.events.list.*;
import it.polimi.ingsw.ps11.cranio.player.Player;


public class TextualViewProva extends View {
	
	private Scanner reader;
	private EventHandler<ConsoleInputEvent> inputChangeEvent = new EventHandler<>();
	private EventHandler<Void> stampaEvent = new EventHandler<>();
	private EventHandler<Void> tiraDadiEvent = new EventHandler<>();
	private EventHandler<Void> stampaFamiliare = new EventHandler<>();
	private EventHandler<Player> scegliCarta = new EventHandler<>();
	
	public TextualViewProva() {
		System.out.println("Game start");
		reader = new Scanner(System.in); 
	}
	
	protected boolean readInput(){
		String input = reader.nextLine();

		try{
			interpreta(input);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void start(){
		boolean condiction = true;
		while(condiction){
			condiction = readInput();
		}
		
		System.out.println("Game exit");
		reader.close();
	}
	
	public int scegliCarta(){
		System.out.println("Scegli carta: ");
		int i = reader.nextInt();
		return i;
	}
	
	protected void interpreta(String input) throws Exception{
		//Questo andrà rivisto
		switch (input) {
		case "quit": throw new Exception();
			
		case "stampa": stampaEvent.invoke(null);
			break;
		case "tira dadi": tiraDadiEvent.invoke(null);
			break;
		case "stampa familiare": stampaFamiliare.invoke(null); 
			break;	
		default:
			System.out.println("'" + input + "'" +  " Comando non riconosciuto");
			break;
		}
	}
	
	
	public void addScegliCartaListener(EventListener<Player> listener){
		this.scegliCarta.attach(listener);
	}
	
	public EventHandler<Player> getScegliCarta() {
		return scegliCarta;
	}
	
	public EventHandler<Void> getStampaFamiliare() {
		return stampaFamiliare;
	}
	
	public void stampaDadi(DiceManager diceManager){
		System.out.println("Black: " + diceManager.getBlackDice().getValue() + " white: " + diceManager.getWhiteDice().getValue()+" Orange: " + diceManager.getOrangeDice().getValue());
	}
	
	public EventHandler<Void> getTiraDadiEvent() {
		return tiraDadiEvent;
	}
	
	public EventHandler<Void> getStampaEvent() {
		return stampaEvent;
	}
	
	public EventHandler<ConsoleInputEvent> getInputChangeEvent() {
		return inputChangeEvent;
	}
	
}
