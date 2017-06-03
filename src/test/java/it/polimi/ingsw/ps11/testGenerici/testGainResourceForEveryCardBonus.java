package it.polimi.ingsw.ps11.testGenerici;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.ps11.cranio.bonus.GainResourceForEveryCardYouHave;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;

public class testGainResourceForEveryCardBonus {
	
	private GainResourceForEveryCardYouHave bonus;
	private GreenCard greenCard = new GreenCard();
	private Player player = new Player();
	private ResourceList resourceList = new ResourceList();

	@Before
	public void constructor(){
		
		resourceList.setResource(new Coin(1));
		bonus = new GainResourceForEveryCardYouHave(GreenCard.class, resourceList.clone());
	}
	
	@Test
	public void testEffectivness(){
		Assert.assertEquals(null, player.getCardManager().getCardList(GreenCard.class));
		
		greenCard.addPermanentBonus(bonus);
		greenCard.take(player, new ResourceList());
		
		greenCard.enablePermanentBonus();
		
		GreenCard nuova = new GreenCard();
		nuova.addPermanentBonus(bonus);
		nuova.take(player, new ResourceList());
		
		nuova.enablePermanentBonus(); 
		
		Assert.assertEquals(2, player.getCardManager().getCardList(GreenCard.class).size());
		
		Assert.assertEquals(8, player.getResourceList().getValueOf(Coin.class)); //8 coins, perchè i bonus uguali sono 2. ovviamente nel gioco non capita mai
	}

}
