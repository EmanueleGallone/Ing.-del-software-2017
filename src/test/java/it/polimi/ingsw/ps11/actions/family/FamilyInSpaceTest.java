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
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInSpaceTest {

	Player player1, player2;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember1, orangeFamilyMember;
	FamilyMember familyMember2, blackFamilyMember;
			
	GameLogic gameLogic;
	FamilyInSpaceAction action1;
	StateHandler handler1, handler2;
	ActionManager aManager1, aManager2;
		
	ActionSpace actionSpace = new ActionSpace();
	
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
		handler1 = new StateHandler(gameLogic, player1);
		handler2 = new StateHandler(gameLogic, player2);
		
		//Prendo l'action manager del Giocatore 1 
		aManager1 = handler1.actions();
		aManager2 = handler2.actions();
		//Inizializzo le risorse del Giocatore 1
			
		player1.getResourceList().setResource(new Coin(3));
						
		//initializeTower(tower);	
	}

	@Test
	public void isLegalandCheckCostTest(){
		
		actionSpace = new ActionSpace(3);
													//il primo piano ha costo 3
		player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class).setModifier(0);	//il familiare neutro ha valore 0
		player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).setModifier(3);	//il familiare arancione ha valore 3
		
		action1 = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), actionSpace);
		assertTrue(action1.isLegal());															//valore sufficiente
		
		action1 = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class), actionSpace);
		assertFalse(action1.isLegal()); 														//valore troppo basso
		
		action1.incrementServant(3); 															//aggiungo 3 servitori
		assertTrue(action1.isLegal());															//valore sufficiente
		
		action1.perform();
		action1 = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), actionSpace);
		assertFalse(action1.isLegal());															//il costo è sufficiente, ma lo spazio è occupato
	
	}
	
	@Test
	public void performTest(){
		
		ResourceList resourceList = new ResourceList(new Coin(3));
		actionSpace = new ActionSpace(resourceList);
		
		player1.getFamilyManager().getFamilyMember(NeutralFamilyMember.class).setModifier(0);
		player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).setModifier(3);
		
		assertEquals(0, player1.getResourceList().get(Coin.class));
		
		action1 = new FamilyInSpaceAction(aManager1, player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), actionSpace);
		action1.perform();
		
		assertEquals(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class),actionSpace.getFamilyMember());
		assertEquals(player1,actionSpace.getOwner());
		
		assertTrue(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).isUsed());
		assertEquals(3, player1.getResourceList().getResource(Coin.class));
		
	}
}
