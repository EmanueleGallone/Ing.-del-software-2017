package it.polimi.ingsw.ps11.model.loaders;
/*
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.cards.effects.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.yield.Yield;
*/
public class InitializeBoard {
/*	
	public static void main(String[] args) throws FileNotFoundException{
		//initializeTextualCommands();
		//inizializzatoreBoard();
		
	}
	

	public void initializePlayer(){

		Player defaultPlayer = new PlayerFactory().newPlayer(0);
		new Loader(FileRegistry.player).write(defaultPlayer);
	}
 
	public static Board inizializzatoreBoard(){
		
// ___________ TUTTE LE TORRI ____________________________
		
		Tower greenTower = new Tower("GreenTower");
		greenTower.addFloor(new Floor(1));
		greenTower.addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		
		resource.setResource(new Wood(1));
		greenTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Wood(2));
		greenTower.addFloor(new Floor(7,resource.clone()));
		
		
		Tower blueTower = new Tower("BlueTower");
		resource = new ResourceList();
		
		blueTower.addFloor(new Floor(1));
		blueTower.addFloor(new Floor(3));
		
		resource.setResource(new Stone(1));
		blueTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Stone(2));
		blueTower.addFloor(new Floor(7,resource.clone()));
		
		
		Tower yellowTower = new Tower("YellowTower");
		resource = new ResourceList();
		
		yellowTower.addFloor(new Floor(1));
		yellowTower.addFloor(new Floor(3));
		
		resource.setResource(new MilitaryPoint(1));
		yellowTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new MilitaryPoint(2));
		yellowTower.addFloor(new Floor(7,resource.clone()));
		
	
		Tower purpleTower = new Tower("PurpleTower");
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
		
		Board board = null;
		
		
// _______________ CouncilPalace _________________________________
		
		CouncilPalace councilPalace = new CouncilPalace();
		councilPalace.setBonus(new ResourceList(new Coin(1)));
		
		ResourceList resourceList = new ResourceList();
		ArrayList<ResourceList> councilPrivilegeResourceLists = new ArrayList<>();
		//per settare il privilegio del consiglio. io lo sposterei all'interno del costruttore del privilegio
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Stone(1));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new Servant(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new Coin(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList();
		
		councilPalace.addEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		
		try {
			board = new Board(towers, market, new DiceManager(dices), new CouncilPalace());
			board.setHarvest(new Yield(new GreenCard().getId())); //creazione zona produzione e raccolta
			board.setProduction(new Yield(new YellowCard().getId()));
			board.setCouncilPalace(councilPalace);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Loader(FileRegistry.board).write(board,Board.class);
		//CustomFileReaderWriter.writeFile("settings\\board", gAdapter.toJson(board));
		return board;
	}
	*/
	
}






