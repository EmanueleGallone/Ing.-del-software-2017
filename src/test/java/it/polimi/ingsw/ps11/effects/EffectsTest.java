package it.polimi.ingsw.ps11.effects;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.effects.ActiveYieldEffect;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.cards.effects.AnotherCard;
import it.polimi.ingsw.ps11.model.cards.effects.CardDiscount;
import it.polimi.ingsw.ps11.model.cards.effects.ChangeTowerTax;
import it.polimi.ingsw.ps11.model.cards.effects.CostIncrementEffect;
import it.polimi.ingsw.ps11.model.cards.effects.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.cards.effects.DecrementResourceEffect;
import it.polimi.ingsw.ps11.model.cards.effects.DisableCardVictoryPoint;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.cards.effects.ExchangeEffect;
import it.polimi.ingsw.ps11.model.cards.effects.FamilyInFloorBonus;
import it.polimi.ingsw.ps11.model.cards.effects.FamilyInSpaceBonus;
import it.polimi.ingsw.ps11.model.cards.effects.FamilyInYieldBonus;
import it.polimi.ingsw.ps11.model.cards.effects.FixFamilyValueEffect;
import it.polimi.ingsw.ps11.model.cards.effects.IncrementForCard;
import it.polimi.ingsw.ps11.model.cards.effects.ResourceAtTheEnd;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeStateAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DoSeveralTimeAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ExchangeAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;



public class EffectsTest {
	
	private ArrayList<Player> initializePlayers(){
		PlayerFactory factory = new PlayerFactory();
		ArrayList<Player> players = new ArrayList<>();
		for(int i = 0; i < 4; i++)
			players.add(factory.newPlayer(i));
		
		return players;
	}

	@Test
	public void incrementForCardTest() {
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new IncrementForCard(new GreenCard().getId(), new ResourceList(new Servant(1)));

		assertEquals(DoSeveralTimeAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void activeYieldEffectTest() {
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new ActiveYieldEffect(new YellowCard().getId(), 1);

		assertEquals(ActiveYieldAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void addResourceEffectTest() {
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new AddResourceEffect(new ResourceList(new FaithPoint(1)));

		assertEquals(IncrementAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void anotherCardTest() {
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new AnotherCard(new PurpleCard().getId(), 6);

		assertEquals(ChangeStateAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void cardDiscountTest() {
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new CardDiscount(new PurpleCard().getId(), new ResourceList(new Stone(1)));

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void changeTowerTaxTest() {
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new ChangeTowerTax(new ResourceList());

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void costIncrementEffectTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new CostIncrementEffect(new GreenCard().getId(), 6);

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void councilPrivilegeTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		ArrayList<ResourceList> resourceLists = new ArrayList<>();
		resourceLists.add(new ResourceList(new Stone(2)));
		Effect effect = new CouncilPrivilege(resourceLists);

		assertEquals(ChangeStateAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void decrementResourceEffectTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new DecrementResourceEffect( new ResourceList(new Stone(1)));

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void disableCardVictoryPointTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new DisableCardVictoryPoint(new PurpleCard().getId());

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void exchangeEffectTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new ExchangeEffect();

		assertEquals(ExchangeAction.class, effect.get(aManager).getClass());
		
		
		HashMap<ResourceList, ResourceList> map = new HashMap<>();
		map.put(new ResourceList(new Stone(1)), new ResourceList(new Wood(2)));
		ExchangeEffect exchangeEffect = new ExchangeEffect(map);
		exchangeEffect.addExchange(new ResourceList(new Coin(1)), new ResourceList(new Servant(5)));
		
		assertEquals(ExchangeAction.class, exchangeEffect.get(aManager).getClass());
	}
	
	@Test
	public void familyInFloorBonusTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new FamilyInFloorBonus(new PurpleCard().getId(), 2);

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void familyInSpaceBonusTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new FamilyInSpaceBonus(new OrangeFamilyMember().getId(), -2);

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void familyInYieldBonusTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new FamilyInYieldBonus(new GreenCard().getId(), -2);

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}
	
	@Test
	public void fixFamilyValueTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new FixFamilyValueEffect(new OrangeFamilyMember().getId(), -1);

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}

	@Test
	public void resourceAtTheEndTest(){
		ArrayList<Player> players = initializePlayers();
		
		GameLogic gameLogic = new GameLogic(players);
		StateHandler stateHandler = gameLogic.getPlayerStatus().get(0);
		ActionManager aManager = stateHandler.actions();
		
		Effect effect = new ResourceAtTheEnd(new ResourceList(new Stone(1)));

		assertEquals(EmptyAction.class, effect.get(aManager).getClass());
	}

}
