package it.polimi.ingsw.ps11.testGenerici;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.malus.thirdPeriod.TakeNoVictoryPointsFromCard;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;

public class TakeNoVictoryPointTest {

	private Excommunication greenCardExcommunication;
	private Player player;
	
	@Before
	public void contructor(){
		player = new Player();
		greenCardExcommunication = new TakeNoVictoryPointsFromCard(player,GreenCard.class); //attenzione! la scomunica è solo sulle carte verdi così
	}
	
	@Test
	public void testEffectivness(){
		GreenCard greenCard = new GreenCard();
		PurpleCard purpleCard = new PurpleCard();
		
		ResourceList resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(8));
		
		greenCard.addPermanentBonus(new IncrementResourceBonus(resourceList.clone())); //aggiungo il bonus alla carta verde
		
		resourceList.setResource(new VictoryPoint(16));
		purpleCard.addPermanentBonus(new IncrementResourceBonus(resourceList.clone())); //aggiungo il bonus alla carta viola
		
		Assert.assertTrue( resourceList.greaterEquals(new ResourceList())); //semplice verifica che la resourceList sia più grande di una vuota
		
		greenCard.take(player, new ResourceList()); //aggiungo prima carta al giocatore
		purpleCard.take(player, new ResourceList()); //aggiungo seconda carta

		
		Assert.assertTrue(player.getCardManager().getCardList(GreenCard.class).size() == 1); //deve esserci esattamente una carta verde
		Assert.assertTrue(player.getCardManager().getCardList(PurpleCard.class).size() == 1);
		
		greenCardExcommunication.behaviour(); //attivare la scomunica (PRIMA DELL'ATTIVAZIONE DELL'EFFETTO DELLA CARTA. altrimenti non funziona
		greenCard.enablePermanentBonus();
		purpleCard.enablePermanentBonus();
		
		IncrementResourceBonus dopoAttivazioneScomunica = (IncrementResourceBonus) player.getCardManager().getCardList(greenCard.getClass()).get(0).
				getPermanentBonus().get(0);
		
		IncrementResourceBonus dopoAttivazioneScomunicaCartaPurple = (IncrementResourceBonus) player.getCardManager().getCardList(purpleCard.getClass()).get(0).
				getPermanentBonus().get(0);
		
		Assert.assertEquals(0, dopoAttivazioneScomunica.getResourceList().getValueOf(VictoryPoint.class));
		Assert.assertEquals(16, dopoAttivazioneScomunicaCartaPurple.getResourceList().getValueOf(VictoryPoint.class)); //l'altra carta deve essere immutata
		
		Assert.assertEquals(16, player.getResourceList().getResource(VictoryPoint.class).getValue()); // dopo aver attivato le carte, l'effetto della carta viola
																									//deve essere il solo ad essersi attivato
		
	}

}
