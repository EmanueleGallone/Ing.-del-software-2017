package it.polimi.ingsw.ps11.actions.family;

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
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class FamilyInFloorTest {

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
	public void checkFloorTest(){
		
	}
	
	@Test
	public void isLegalTest(){
		
	}
	
	
	@Test
	public void performTest(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
