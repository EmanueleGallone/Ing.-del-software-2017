package it.polimi.ingsw.ps11.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInTowerTest {

	
	@Test
	public void familyInTowerTest(){
		
		//Inizializzo l'action manager e il player
		Player player = new Player("Giocatore 1");
		Player player_2 = new Player("Giocatore 2");
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		players.add(player_2);
			
		GameLogic gameLogic = new GameLogic(players);
		ActionManager aManager = null;
		
		//Prendo l'action manager del Giocatore 1 
		for(StateHandler stateHandler : gameLogic.getPlayerStatus()){
			if(stateHandler.getPlayer().getName().equals("Giocatore 1"))
				aManager = stateHandler.actions();
		}
		
		//Inizializzo le risorse del Giocatore 1

		ResourceList playerResources = player.getResourceList();
		playerResources.setResource(new Coin(3));
		
		
		Tower tower = gameLogic.getGame().getBoard().getTower(GreenTower.class);
		//initializeTower(tower);
		
		

		FamilyMember familyMember = new NeutralFamilyMember();
		
		FamilyInTowerAction towerAction = new FamilyInTowerAction(aManager, tower, familyMember);
		
		//Non c'e' nessuno sulla torre quindi il giocatore non dovra' pagare la tassa e avra' sempre 3 coin

		assertTrue(towerAction.isLegal());
		if(towerAction.isLegal())
			towerAction.perform();
		
		Coin coin = playerResources.get(Coin.class);
		assertEquals(coin.getValue(), 3);
		
		//_________________________ Caso torre non vuota ________________________
		
		//In questo caso invece sulla torre c'e' gia' un giocatore percio' dovra' pagare 3 monete
		
		Floor floor = tower.getFloor(0); // prendo il primo piano
		floor.getActionSpace().placeFamilyMember(new BlackFamilyMember(), player_2);
		
		if(towerAction.isLegal())
			towerAction.perform();
		assertEquals(playerResources.get(Coin.class), new Coin(0));
		
	}
}
