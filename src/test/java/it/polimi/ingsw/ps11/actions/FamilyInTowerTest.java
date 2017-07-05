package it.polimi.ingsw.ps11.actions;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FamilyInTowerTest {

	
	
	public void initializeTower(Tower tower){
		tower.addFloor(new Floor());
		tower.addFloor(new Floor());
		tower.addFloor(new Floor());
		tower.addFloor(new Floor());
	}
	
	@Test
	public void familyInTowerTest(){
		
		//Inizializzo l'action manager e il player
		Player player = new Player("Giocatore 1");
		Player player_2 = new Player("Giocatore 2");
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		players.add(player_2);
		
		GameLogic gameLogic = new GameLogic(players);
		ActionManager aManager = gameLogic.getPlayerStatus().get(0).actions();
		
		//Inizializzo le risorse del player
		ResourceList playerResources = player.getResourceList();
		playerResources.setResource(new Coin(3));
		
		
		Tower tower = gameLogic.getGame().getBoard().getTower(GreenTower.class);
		//initializeTower(tower);
		
		
		FamilyMember familyMember = player.getFamilyManager().getFamilyMember(BlackFamilyMember.class);
		
		FamilyInTowerAction towerAction = new FamilyInTowerAction(aManager, tower, familyMember);
		
		//Non c'e' nessuno sulla torre quindi il giocatore non dovra' pagare la tassa e avra' sempre 3 coin
		if(towerAction.isLegal())
			towerAction.perform();
		
		Coin coin = playerResources.get(Coin.class);
		assertEquals(coin.getValue(), 3);
		
		//_________________________ Caso torre non vuota ________________________
		
		//In questo caso invece sulla torre c'e' gia' un giocatore percio' dovra' pagare 3 monete
		
		Floor floor = tower.getFloor(0); // prendo il primo piano
		floor.getActionSpace().placeFamilyMember(familyMember, player_2);
		
		if(towerAction.isLegal())
			towerAction.perform();
		assertEquals(playerResources.get(Coin.class), new Coin(0));
		
	}
}
