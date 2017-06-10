package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.game.actionsEma.IncrementResourceAction;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class GainResourceForEveryCardYouHave extends PlayerBonus{
	
	private ResourceList resourceList;
	private String cardType;
	
	public GainResourceForEveryCardYouHave(Class<? extends DevelopmentCard> cardClass, ResourceList resource) {
		this.cardType = cardClass.toString();
		resourceList = resource;
	}

	@Override
	public void behavior() {
		for(DevelopmentCard card : getPlayer().getCardManager().getCardList(cardType))
			new IncrementResourceAction(getPlayer(), resourceList).perform();		
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public ResourceList getResourceList() {
		return resourceList;
	}

}
