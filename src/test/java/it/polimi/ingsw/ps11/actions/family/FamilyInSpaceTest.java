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
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInSpaceTest {

	Player player;
	
	ArrayList<Player> players;
	
	FamilyMember familyMember1, orangeFamilyMember;
			
	GameLogic gameLogic;
	FamilyInSpaceAction action1;
	StateHandler handler;
	ActionManager aManager;
		
	ActionSpace actionSpace = new ActionSpace();
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setting(){
		
		//Inizializzo l'action manager e il player
		player = new Player("Giocatore 1");
		
		players = new ArrayList<>();
		players.add(player);
		
		familyMember1 = new NeutralFamilyMember();	
		orangeFamilyMember = new OrangeFamilyMember();
		
		player.getFamilyManager().setFamilyMember(familyMember1);
		player.getFamilyManager().setFamilyMember(orangeFamilyMember);

			
		gameLogic = new GameLogic(players);
		handler = new StateHandler(gameLogic, player);
		
		//Prendo l'action manager del Giocatore 1 
		aManager = handler.actions();
		//Inizializzo le risorse del Giocatore 1
			
		player.getResourceList().setResource(new Coin(3), new Servant(3));		//ERRORE, chiede servitori anche se c'è il modifier
						
		//initializeTower(tower);	
	}

	@Test
	public void isLegalandCheckCostTest(){
		
		actionSpace = new ActionSpace(3);														//il primo piano ha costo 3
													
		player.getFamilyManager().getFamilyMember(NeutralFamilyMember.class).setModifier(0);	//il familiare neutro ha valore 0
		player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).setModifier(4);		//il familiare arancione ha valore 4
		
		action1 = new FamilyInSpaceAction(aManager, player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), actionSpace);
		assertTrue(action1.isLegal());															//valore sufficiente
		
		action1 = new FamilyInSpaceAction(aManager, player.getFamilyManager().getFamilyMember(NeutralFamilyMember.class), actionSpace);
		assertFalse(action1.isLegal()); 														//valore troppo basso
		
		action1.incrementServant(3); 															//aggiungo 3 servitori
		assertTrue(action1.isLegal());															//valore sufficiente
		
		action1.perform();
		action1 = new FamilyInSpaceAction(aManager, player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), actionSpace);
		assertFalse(action1.isLegal());															//il costo è sufficiente, ma lo spazio è occupato
	
	}
	
	@Test
	public void performTest(){
		
		ResourceList resourceList = new ResourceList(new Coin(3));
		actionSpace = new ActionSpace(resourceList);
		
		player.getFamilyManager().getFamilyMember(NeutralFamilyMember.class).setModifier(0);
		player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).setModifier(3);
		
		assertEquals(3, player.getResourceList().get(Coin.class).getValue());
		
		action1 = new FamilyInSpaceAction(aManager, player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), actionSpace);
		action1.perform();
		
		assertEquals(player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class),actionSpace.getFamilyMember());
		assertEquals(player,actionSpace.getOwner());
		
		assertTrue(player.getFamilyManager().getFamilyMember(OrangeFamilyMember.class).isUsed());
		assertEquals(6, player.getResourceList().getResource(Coin.class).get().getValue());
		
	}
}
