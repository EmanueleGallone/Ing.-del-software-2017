package it.polimi.ingsw.ps11.zones;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;

public class CouncilPalaceTest {

	@Test
	public void test() {
		Game game = new Game(new PlayerFactory().takeAll());
		ArrayList<Player> players = (ArrayList<Player>) game.getRoundManager().getCurrentOrder().clone();
		Assert.assertEquals(4, players.size());
		int i = 0;
		for(Player p : players){
			p.setName("giocatore" + i); //cambio il nome ai giocatori
			i++;
		}
		Assert.assertEquals("giocatore0", players.get(0).getName());
		CouncilPalace councilPalace = game.getBoard().getCouncilPalace();
		
		Assert.assertEquals(players.get(1), game.getRoundManager().getCurrentOrder().get(1)); //testo la posizione nel roundManager
		
		//posiziono dei familiari
		councilPalace.getFreeSpace().placeFamilyMember(new OrangeFamilyMember().getFrom(players.get(3).getFamilyManager()), players.get(3));
		councilPalace.getFreeSpace().placeFamilyMember(new OrangeFamilyMember().getFrom(players.get(1).getFamilyManager()), players.get(1));
		
		Assert.assertTrue(councilPalace.contains(players.get(3)));
		Assert.assertFalse(councilPalace.contains(players.get(0))); //il palazzo non deve contenere il primo giocatore. Non ha posizionato
		
		Assert.assertEquals(2, councilPalace.getNewOrder().size()); //testo il numero di giocatori che hanno posizionato nel palazzo
		
		Assert.assertEquals(4, game.getRoundManager().getCurrentOrder().size());
		game.getRoundManager().setNewOrder(councilPalace.getNewOrder()); //cambio l'ordine
		Assert.assertEquals(players.get(3), game.getRoundManager().getCurrentOrder().get(0)); //il quarto giocatore deve ora essere il primo
		Assert.assertEquals(4, game.getRoundManager().getCurrentOrder().size()); //il round manager deve contenere lo stesso numero di giocatori
		
	}
	
	@Test
	public void councilPalaceEffectsTest(){
		GameLogic game = new GameLogic(new PlayerFactory().take(4));
		CouncilPalace councilPalace = game.getGame().getBoard().getCouncilPalace();
		StateHandler stateHandler = game.getPlayerStatus().get(0);
		ActionManager actionManager = stateHandler.actions();
		
		Assert.assertEquals(1, councilPalace.getBonus().get("Coin").getValue());
		Assert.assertNotNull(councilPalace.getEffects(actionManager));
		
		councilPalace.setBonus(new ResourceList(new Wood(1)));
		Assert.assertEquals(1, councilPalace.getBonus().getResources().size());
		
		councilPalace.addEffect(new AddResourceEffect(new ResourceList(new Coin(1)))); //aggiungo un ulteriore effetto
		Assert.assertEquals(2, councilPalace.getEffects(actionManager).size());
		
	}

}
