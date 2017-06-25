package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class GetCard implements Action {

	private Player player;
	private DevelopmentCard card;
	private ResourceList cost;
	
	public GetCard(Player player, DevelopmentCard card, ResourceList cost) {
		this.player = player;
		this.card = card;
		this.cost = cost;
	}

	@Override
	public void perform() {
		ActionManager aManager = getSource().actions();
		
		for(Action effect : card.getIstantEffect()){
			effect.enable(aManager);
		}
		
		for(ActionDecorator<?> decorator : card.getPermanentEffect()){
			aManager.add(decorator);
		}
		
	}

	@Override
	public Player getSource() {
		return player;
	}
	@Override
	public boolean isLegal() {
	 boolean result = card.getCosts().contains(cost);
	 result = result && getSource().getResourceList().canSubtract(cost);
	 return result;
	}
	

	@Override
	public ActionDecorator<GetCard> enable(ActionManager aManager) {
		ActionDecorator<GetCard> decorator = aManager.get(GetCard.class);
		return decorator.decore(this);
	}

	
}
