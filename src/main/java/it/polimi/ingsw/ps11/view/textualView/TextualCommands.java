package it.polimi.ingsw.ps11.view.textualView;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps11.model.zones.towers.*;
import it.polimi.ingsw.ps11.view.viewEvents.AskUpdateEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.*;



public class TextualCommands {
	
	private Map<String, ViewEvent> commands = new HashMap<String, ViewEvent>();

	private String instructions ;
	
	public TextualCommands() {
	  // initializeEventMap();
	  // initializeInstruction();
	}
	
	public ViewEvent get(String input){
		return commands.get(input);
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	
	private void initializeInstruction(){
		instructions = "\n\nINSTRUCTION:"
				+ "\n • If you want select the floor of a tower type \" yellow tower 1 \""
				+ "\n • If you want select a family member (e.g. orange) -> orange family "
				+ "\n • If you want select production or harvest type \"production\" or \"harvest\""
				+ "\n"; 
	}
	
	private void initializeEventMap(){
	
	commands.put("yellow tower 1", new FloorSelectedEvent(YellowTower.class, 0));
	commands.put("yellow tower 2", new FloorSelectedEvent(YellowTower.class, 1));
	commands.put("yellow tower 3", new FloorSelectedEvent(YellowTower.class, 2));
	commands.put("yellow tower 4", new FloorSelectedEvent(YellowTower.class, 3));
	commands.put("green tower 1", new FloorSelectedEvent(GreenTower.class, 0));
	commands.put("green tower 2", new FloorSelectedEvent(GreenTower.class, 1));
	commands.put("green tower 3", new FloorSelectedEvent(GreenTower.class, 2));
	commands.put("green tower 4", new FloorSelectedEvent(GreenTower.class, 3));
	commands.put("blue tower 1", new FloorSelectedEvent(BlueTower.class, 0));
	commands.put("blue tower 2", new FloorSelectedEvent(BlueTower.class, 1));
	commands.put("blue tower 3", new FloorSelectedEvent(BlueTower.class, 2));
	commands.put("blue tower 4", new FloorSelectedEvent(BlueTower.class, 3));
	commands.put("purple tower 1", new FloorSelectedEvent(PurpleTower.class, 0));
	commands.put("purple tower 2", new FloorSelectedEvent(PurpleTower.class, 1));
	commands.put("purple tower 3", new FloorSelectedEvent(PurpleTower.class, 2));
	commands.put("purple tower 4", new FloorSelectedEvent(PurpleTower.class, 3));
	
	commands.put("market 1", new MarketSelectedEvent(0));
	commands.put("market 2", new MarketSelectedEvent(1));
	commands.put("market 3", new MarketSelectedEvent(2));
	commands.put("market 4", new MarketSelectedEvent(3));

	commands.put("production" , new ProductionSelectedEvent());
	commands.put("harvest" , new HarvestSelectedEvent());
	
	commands.put("update" , new AskUpdateEvent());
}
}
