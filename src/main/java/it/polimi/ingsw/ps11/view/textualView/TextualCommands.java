package it.polimi.ingsw.ps11.view.textualView;

import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;



public class TextualCommands {

	private Map<String, ViewEvent> commands = new HashMap<String, ViewEvent>();
	private String instructions ;
	
	public TextualCommands() {
//	   initializeEventMap();
//	   initializeInstruction();
	}
	

	
	public ViewEvent get(String input){
		return commands.get(input);
	}
	
	public String getInstructions() {
		return instructions;
	}
	

//	private void initializeInstruction(){
//		instructions = "\n\nINSTRUCTION:"
//				+ "\n • If you want select the floor of a tower type \" yellow tower 1 \""
//				+ "\n • If you want to print the entire board type \" update \" "
//				+ "\n • If you want to select the Council palace type  \" council palace \" "
//				+ "\n • If you want select production or harvest type \"production\" or \"harvest\""
//				+ "\n • If you want select the first action space in the market type \"market 1\""
//				+ "\n • If you want to activate a leader card type \"leader [LeaderCardName]\" "
//				+ "\n • If you want end the turn type \"pass\""
//				+ "\n"; 
//	}
//	
//	private void initializeEventMap(){
//	
//	commands.put("yellow tower 1", new FloorSelectedEvent("YellowTower", 0));
//	commands.put("yellow tower 2", new FloorSelectedEvent("YellowTower", 1));
//	commands.put("yellow tower 3", new FloorSelectedEvent("YellowTower", 2));
//	commands.put("yellow tower 4", new FloorSelectedEvent("YellowTower", 3));
//	commands.put("green tower 1", new FloorSelectedEvent("GreenTower", 0));
//	commands.put("green tower 2", new FloorSelectedEvent("GreenTower", 1));
//	commands.put("green tower 3", new FloorSelectedEvent("GreenTower", 2));
//	commands.put("green tower 4", new FloorSelectedEvent("GreenTower", 3));
//	commands.put("blue tower 1", new FloorSelectedEvent("BlueTower", 0));
//	commands.put("blue tower 2", new FloorSelectedEvent("BlueTower", 1));
//	commands.put("blue tower 3", new FloorSelectedEvent("BlueTower", 2));
//	commands.put("blue tower 4", new FloorSelectedEvent("BlueTower", 3));
//	commands.put("purple tower 1", new FloorSelectedEvent("PurpleTower", 0));
//	commands.put("purple tower 2", new FloorSelectedEvent("PurpleTower", 1));
//	commands.put("purple tower 3", new FloorSelectedEvent("PurpleTower", 2));
//	commands.put("purple tower 4", new FloorSelectedEvent("PurpleTower", 3));
//	
//	commands.put("market 1", new MarketSelectedEvent(0));
//	commands.put("market 2", new MarketSelectedEvent(1));
//	commands.put("market 3", new MarketSelectedEvent(2));
//	commands.put("market 4", new MarketSelectedEvent(3));
//
//	commands.put("production" , new ProductionSelectedEvent());
//	commands.put("harvest" , new HarvestSelectedEvent());
//	
//	commands.put("update" , new AskUpdateEvent());
//	
//	commands.put("pass" , new EndTurnEvent());
//	
//	commands.put("councilpalace", new CouncilSelectedEvent());
//	commands.put("council palace", new CouncilSelectedEvent());
//}
//	
//	
//	public static void main(String[] args) {
//		TextualCommands commands = new TextualCommands();
//		
//		new Loader("settings\\view\\commands").write(commands);
//	}
}
