package it.polimi.ingsw.ps11.mvc.view;

import java.util.Scanner;

import it.polimi.ingsw.ps11.cranio.dices.DiceManager;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.list.*;


public class TextualView extends View {
	
	private Scanner reader;
	private EventHandler<ConsoleInputEvent> inputChangeEvent = new EventHandler<>();
	private EventHandler<Void> stampaEvent = new EventHandler<>();
	private EventHandler<Void> tiraDadiEvent = new EventHandler<>();
	
	public TextualView() {
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

	protected void interpreta(String input) throws Exception{
		//Questo andrà rivisto
		switch (input) {
		case "quit": throw new Exception();
			
		case "stampa": stampaEvent.invoke(null);
			break;
		case "tira dadi": tiraDadiEvent.invoke(null);
			break;
		default:
			System.out.println("'" + input + "'" +  " Comando non riconosciuto");
			break;
		}
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
