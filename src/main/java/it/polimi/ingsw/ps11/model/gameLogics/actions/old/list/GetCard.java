package it.polimi.ingsw.ps11.model.gameLogics.actions.old.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class GetCard extends PlayerAction {

	private DevelopmentCard card;
	private ResourceList cost;
	
	public GetCard(Player player, DevelopmentCard card, ResourceList cost) {
		super(player);
		this.card = card;
		this.cost = cost.clone();
	}

	@Override
	public void perform() {
		DecrementResourceAction tax = new DecrementResourceAction(getPlayer(), cost);
		actionManager().perform(tax);
		getPlayer().getCardManager().addCard(card);
	}

	@Override
	public boolean isLegal() {
		boolean result = card.checkCost(getPlayer().getResourceList(), cost);
		return result && getPlayer().getCardManager().canAdd(card);
	}
	
	public DevelopmentCard getCard() {
		return card;
	}
	public ResourceList getCost() {
		return cost;
	}
}
