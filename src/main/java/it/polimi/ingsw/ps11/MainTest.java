package it.polimi.ingsw.ps11;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.JsonAdapter;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.ActiveYieldLeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.AddResourceLeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.DiscountLeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.UniqueEffectLeaderCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.dices.Dice;
import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.model.excommunications.Excommunication;
import it.polimi.ingsw.ps11.model.excommunications.TakeCardMinus4Excommunication;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ActiveYieldEffect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.AnotherCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.CardDiscount;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ExchangeEffect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.FamilyInFloorBonus;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.FamilyInYieldBonus;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.IncrementForCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ResourceAtTheEnd;
import it.polimi.ingsw.ps11.model.loaders.CustomFileReaderWriter;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
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
import it.polimi.ingsw.ps11.view.textualView.TextualCommands;

public class MainTest {
	
	public static void main(String[] args) throws FileNotFoundException{
		//LeaderCardsInitializer();
		//initializeTextualCommands();
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
		CustomFileReaderWriter.writeFile("settings\\board", gAdapter.toJson(board));
		return board;
	}
	
	
	public static void initializeTextualCommands(){
		
		TextualCommands commands = new TextualCommands();
		
		CustomFileReaderWriter.writeFile("settings\\textualCommands", new JsonAdapter().toJson(commands));
	}
	
}






