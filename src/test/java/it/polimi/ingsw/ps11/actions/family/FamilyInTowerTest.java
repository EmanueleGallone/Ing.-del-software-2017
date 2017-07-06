package it.polimi.ingsw.ps11.actions.family;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInTowerTest {

	Player player1, player2;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember1, orangeFamilyMember;
	FamilyMember familyMember2, blackFamilyMember;
	
	ResourceList player1Resources;
		
	GameLogic gameLogic;
	ActionManager aManager;
	FamilyInTowerAction action1;
	
	Tower tower;
	Floor floor1, floor2, floor3, floor4;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setting(){
		
		//Inizializzo l'action manager e il player
		player1 = new Player("Giocatore 1");
		player2 = new Player("Giocatore 2");
		
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		
		familyMember1 = new NeutralFamilyMember();	
		orangeFamilyMember = new OrangeFamilyMember();
		
		familyMember2 = new NeutralFamilyMember();	
		blackFamilyMember = new BlackFamilyMember();
		
		player1.getFamilyManager().setFamilyMember(familyMember1);
		player1.getFamilyManager().setFamilyMember(orangeFamilyMember);

		player2.getFamilyManager().setFamilyMember(familyMember2);
		player2.getFamilyManager().setFamilyMember(blackFamilyMember);
			
		gameLogic = new GameLogic(players);
		aManager = null;
		
		//Prendo l'action manager del Giocatore 1 
		for(StateHandler stateHandler : gameLogic.getPlayerStatus()){
			if(stateHandler.getPlayer().getName().equals("Giocatore 1"))
				aManager = stateHandler.actions();
		}
		//Inizializzo le risorse del Giocatore 1
			
		player1.getResourceList().setResource(new Coin(3));
						
		//initializeTower(tower);	
		Tower tower = gameLogic.getGame().getBoard().getTower(GreenTower.class);
		
		floor1 = tower.getFloor(0);
		floor2 = tower.getFloor(1);
		floor3 = tower.getFloor(2);
		floor4 = tower.getFloor(3);
			
	}
	
	@Test
	public void performTest(){
		
		//exception.expect(NullPointerException.class);
		//Prima di eseguire l'azione il piano è vuoto e il player ha 3 monete
		assertNull(floor1.getActionSpace().getFamilyMember());
		assertNull(floor1.getActionSpace().getOwner());
		
		//Dopo aver eseguito l'azione nel piano c'è il familiare del giocatore giusto, dato che la torre era vuota, il player ha ancora 3 monete
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		action1.perform();
		
		assertEquals(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), floor1.getActionSpace().getFamilyMember());
		assertEquals(floor1.getActionSpace().getOwner(), player1);
		
		//Dopo aver eseguito l'azione nel piano c'è il familiare del giocatore giusto, dato che la torre conteneva già un familiare, il player spende 3 monete
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class));
		action1.perform();
		
		assertEquals(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), floor1.getActionSpace().getFamilyMember());
		assertEquals(floor1.getActionSpace().getOwner(), player1);
	
	}
	
	@Test
	public void containsTest(){
		
		assertFalse(action1.contains(tower, player1));
		
		//Aggiungo un familiare neutro, considerata ancora vuota
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class));		
		action1.perform();

		assertFalse(action1.contains(tower, player1));
		
		//Aggiungo un familiare non neutro, tower contains il giocatore
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		action1.perform();

		assertTrue(action1.contains(tower, player1));

	}
	
	@Test
	public void isLegalTest(){
		
		//exception.expect(NullPointerException.class);
		//Prima di eseguire l'azione il piano è vuoto e il player ha 3 monete
		assertNull(floor1.getActionSpace().getFamilyMember());
		assertNull(floor1.getActionSpace().getOwner());
		
		//Aggiungo un familiare neutro sempre possibile
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class));
		assertTrue(action1.isLegal());
		action1.perform();

		//Aggiungo un familiare arancione, il player1 aveva solo un familiare neutro
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		assertTrue(action1.isLegal());
		action1.perform();
		
		//Aggiungo un familiare nero, il player2 non aveva altri familiari
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		assertFalse(action1.isLegal());
		action1.perform();
	
		action1 = new FamilyInTowerAction(aManager, tower, player2.getFamilyManager().getFamilyMember(NeutralFamilyMember.class));
		assertTrue(action1.isLegal());
		
	}
	
	@Test
	public void checkTaxTest(){
		
		//exception.expect(NullPointerException.class);
		//Prima di eseguire l'azione il piano è vuoto e il player ha 3 monete
		assertEquals(3, player1.getResourceList().get(Coin.class).getValue());
		
		//Dopo aver eseguito l'azione nel piano c'è il familiare del giocatore giusto, dato che la torre era vuota, il player ha ancora 3 monete
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class));
		action1.perform();
		
		assertEquals(3, player1.getResourceList().get(Coin.class).getValue());
		
		//Dopo aver eseguito l'azione nel piano c'è il familiare del giocatore giusto, dato che la torre conteneva già un familiare, il player spende 3 monete
		action1 = new FamilyInTowerAction(aManager, tower, player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class));
		action1.perform();
		
		assertEquals(0, player1.getResourceList().get(Coin.class).getValue());
		assertEquals(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), floor1.getActionSpace().getFamilyMember());
		assertEquals(floor1.getActionSpace().getOwner(), player1);
	
	}
}
