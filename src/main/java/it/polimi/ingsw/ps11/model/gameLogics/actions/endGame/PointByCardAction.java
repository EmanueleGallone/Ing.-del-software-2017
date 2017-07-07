package it.polimi.ingsw.ps11.model.gameLogics.actions.endGame;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class PointByCardAction implements Action {

	private ActionManager aManager;
	private String card;
	private HashMap<Integer, ResourceList> rewards = new HashMap<>();
	
	public PointByCardAction(ActionManager aManager, String card, HashMap<Integer, ResourceList> rewards) {
		this.aManager = aManager;
		this.card = card;
		this.rewards = rewards;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		Player player = aManager.state().getPlayer();
		int numberOfCard = player.getCardManager().getCardList(card).size();
		
		ResourceList reward = this.rewards.get(numberOfCard);
		
		if(reward!= null){
			player.getResourceList().sum(reward);
		}
		
	}
	
	public void setActionManager(ActionManager aManager) {
		this.aManager = aManager;
	}
	
	public String getCard() {
		return card;
	}
	public void setRewards(HashMap<Integer, ResourceList> rewards) {
		this.rewards = rewards;
	}

	@Override
	public Action clone() {
		return new PointByCardAction(aManager, card, rewards);
	}

}