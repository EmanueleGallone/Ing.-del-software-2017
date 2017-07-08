package it.polimi.ingsw.ps11.zones;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;

public class MarketTest {
	
	@Test
	public void test(){
		Market market = new Market(2);
		Assert.assertEquals(2, market.getPlayerNumber());
		
		PlayerFactory factory = new PlayerFactory();
		Player player1 = factory.newPlayer(0);
		Player player2 = factory.newPlayer(1);
		
		market.addActionSpace(new ActionSpace(new ResourceList(new Coin(5)))); //creo le prime due action space
		market.addActionSpace(new ActionSpace(new ResourceList(new Servant(5))));
		market.addActionSpace(new ActionSpace(new ResourceList(new MilitaryPoint(5)))); //creo le altre due action sapce
		market.addActionSpace(new ActionSpace(new ResourceList(new Wood(5)))); //fittizio. dovrebbero esserci due councilPrivilege
		
		market.getActionSpace(0).placeFamilyMember(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player1);
		
		try {
			market.getActionSpace(3).placeFamilyMember(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player1);			
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true); //verifico che è stata lanciata l'eccezione
		}
		
		try {
			market.getActionSpace(-1).placeFamilyMember(player1.getFamilyManager().getFamilyMember(OrangeFamilyMember.class), player1);			
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true); //verifico che è stata lanciata l'eccezione. per l'altro branch dell'if
		}
		
		Player player3 = factory.newPlayer(2);
		Player player4 = factory.newPlayer(3);
		
		market.setPlayerNumber(4);
		market.getActionSpace(3).placeFamilyMember(player4.getFamilyManager().getFamilyMember(NeutralFamilyMember.class), player4);
	}

}
