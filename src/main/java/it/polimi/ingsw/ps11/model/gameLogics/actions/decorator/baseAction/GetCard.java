package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.PlayerAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class GetCard extends PlayerAction {

	private DevelopmentCard card;
	private ResourceList cost;
	
	public GetCard(Player player, DevelopmentCard card, ResourceList cost) {
		super(player);
		this.card = card;
		this.cost = cost;
	}

	@Override
	public void perform() {
		ActionManager aManager = getSource().actions();
		
		for(PlayerAction effect : card.getIstantEffect()){
			effect.enable(aManager);
		}
		
		for(ActionDecorator<?> decorator : card.getPermanentEffect()){
			aManager.add(decorator);
		}
		
	}

	@Override
	public boolean isLegal() {
	 boolean result = card.getCosts().contains(cost);
	 result = result && getSource().getResourceList().canSubtract(cost);
	 return result;
	}
	

	@Override
	public void enable(ActionManager aManager) {
		ActionDecorator<GetCard> decorator = aManager.get(GetCard.class);
		Action action = decorator.decore(this);
		if(action.isLegal())
			action.perform();
	}

	
}
