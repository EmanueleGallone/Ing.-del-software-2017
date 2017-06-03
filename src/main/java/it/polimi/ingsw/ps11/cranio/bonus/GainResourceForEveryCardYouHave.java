package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class GainResourceForEveryCardYouHave extends Bonus{
	
	private ResourceList resourceList;
	private String cardType;
	
	public <T extends DevelopmentCard> GainResourceForEveryCardYouHave(Class<T> cardClass, ResourceList resource) {
		this.cardType = cardClass.toString();
		resourceList = resource;
	}

	@Override
	public void behavior() {
		for(DevelopmentCard card : getOwner().getCardManager().getCardList(cardType))
			getOwner().getResourceList().sum(resourceList); //per ogni carta, aggiungi il valore settato nella resource List!
		
	}

}
