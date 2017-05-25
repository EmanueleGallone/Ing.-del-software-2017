package it.polimi.ingsw.ps11.mvc.posView;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.list.TextualViewEvent;
import it.polimi.ingsw.ps11.mvc.posView.component.BoardView;
import it.polimi.ingsw.ps11.mvc.posView.component.PlayerView;
import it.polimi.ingsw.ps11.mvc.posView.component.TowerView;
import it.polimi.ingsw.ps11.mvc.posView.component.io.Console;

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
	
	
	BoardView board = new BoardView();
	PlayerView player = new PlayerView();
	TowerView tower = new TowerView();
	
	public TextualView() {
		
	}
	
// Start Event 
	
	EventHandler<TextualViewEvent> printStatus = new EventHandler<>();
	EventHandler<TextualViewEvent> posizionaFamiliareTorre = new EventHandler<>();
	
	public EventHandler<TextualViewEvent> getPrintStatus() {
		return printStatus;
	}
	public EventHandler<TextualViewEvent> getPosizionaFamiliareTorre() {
		return posizionaFamiliareTorre;
	}
	
// End Event
	
	public boolean execute(String command){
		switch (command) {
		case "0":
			printStatus.invoke(new TextualViewEvent(this));
			break;
		case "1":	
			posizionaFamiliareTorre.invoke(new TextualViewEvent(this));
			break;
		case "p":
			break; 
		case "q":
			return false;
		default: new Console().print("Comando non valido");
			break;
		}
		return true;
	}
	
	public boolean execute(){
		return execute(new Console().read());
	}
	
// Start getters
	
	public BoardView getBoard() {
		return board;
	}
	public PlayerView getPlayer() {
		return player;
	}
	public TowerView getTower() {
		return tower;
	}
	
// End getters

// ____________ START _______________
	
	public void start(){
		
		Console console = new Console();
		
		do { 
			console.print(menuAzione); 
		} while(execute());
	}
}
