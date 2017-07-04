package it.polimi.ingsw.ps11;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.JsonAdapter;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.loaders.Loader;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;

public class MainTest {
	
	public static void main(String[] args) throws FileNotFoundException{
		//LeaderCardsInitializer();
		//initializeTextualCommands();

		
		//______________ Prima __________________________
		ResourceList resourceList = new ResourceList();
		
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Wood(3));
		
		//______________ Dopo ___________________________
	 
		ResourceList resourceListNuova = new ResourceList();
		resourceListNuova.setResource(new Coin(1),new Wood(3));
		
		//Oppure 
		
		ResourceList resourceList_2 = new ResourceList(new Coin(1),new Wood(3));
		
	}
	

	public void initializePlayer(){

		Player defaultPlayer = new PlayerFactory().newPlayer(0);
		new Loader(FileRegistry.player).write(defaultPlayer);
	}
 
	public static Board inizializzatore(){
		
		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		
		JsonAdapter gAdapter = new JsonAdapter(list);
		
// ___________ TUTTE LE TORRI ____________________________
		
		GreenTower greenTower = new GreenTower();
		greenTower.addFloor(new Floor(1));
		greenTower.addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		
		resource.setResource(new Wood(1));
		greenTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Wood(2));
		greenTower.addFloor(new Floor(7,resource.clone()));
		
		
		BlueTower blueTower = new BlueTower();
		resource = new ResourceList();
		
		blueTower.addFloor(new Floor(1));
		blueTower.addFloor(new Floor(3));
		
		resource.setResource(new Stone(1));
		blueTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Stone(2));
		blueTower.addFloor(new Floor(7,resource.clone()));
		
		
		YellowTower yellowTower = new YellowTower();
		resource = new ResourceList();
		
		yellowTower.addFloor(new Floor(1));
		yellowTower.addFloor(new Floor(3));
		
		resource.setResource(new MilitaryPoint(1));
		yellowTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new MilitaryPoint(2));
		yellowTower.addFloor(new Floor(7,resource.clone()));
		
	
		PurpleTower purpleTower = new PurpleTower();
		resource = new ResourceList();
		
		purpleTower.addFloor(new Floor(1));
		purpleTower.addFloor(new Floor(3));
		
		resource.setResource(new Coin(1));
		purpleTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Coin(2));
		purpleTower.addFloor(new Floor(7,resource.clone()));
		
		ArrayList<Tower> towers = new ArrayList<>();
		towers.add(greenTower);
		towers.add(blueTower);
		towers.add(yellowTower);
		towers.add(purpleTower);
		
 // ________ MARKET ________________________________________________
		
		Market market = new Market(2);
		
		resource = new ResourceList(new Coin(5));
		market.addActionSpace(new ActionSpace(resource.clone()));
		
		resource = new ResourceList(new Servant(5));
		market.addActionSpace(new ActionSpace(resource.clone()));
		
		resource = new ResourceList();
		resource.setResource(new Coin(2));
		resource.setResource(new MilitaryPoint(3));
		market.addActionSpace(new ActionSpace(resource.clone()));
//		
//		
  // ___________________________________________________
		
		ArrayList<Dice> dices = new ArrayList<>();
		dices.add(new Dice("Black"));
		dices.add(new Dice("White"));
		dices.add(new Dice("Orange"));
		
		Board board = new Board(towers, market, new DiceManager(dices), new CouncilPalace());
		
		new Loader(FileRegistry.board).write(board);
		//CustomFileReaderWriter.writeFile("settings\\board", gAdapter.toJson(board));
		return board;
	}
	
	
//	public static void initializeTextualCommands(){
//		
//		TextualCommands commands = new TextualCommands();
//		
//		CustomFileReaderWriter.writeFile("settings\\textualCommands", new JsonAdapter().toJson(commands));
//	}
	
}






