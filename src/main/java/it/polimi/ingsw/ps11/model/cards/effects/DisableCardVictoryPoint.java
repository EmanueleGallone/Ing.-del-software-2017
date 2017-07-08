package it.polimi.ingsw.ps11.model.cards.effects;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.PointByCardAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DisableCardVictoryPoint implements Effect{

	private String card;
	private HashMap<Integer, ResourceList> rewards;
	
	public DisableCardVictoryPoint(String card) {
		this(card,new HashMap<>());
	}
	
	public DisableCardVictoryPoint(String card, HashMap<Integer, ResourceList> resource) {
		this.rewards = resource;
		this.card = card;
	}

	@Override
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		PointByCardAffecter affecter = new PointByCardAffecter(card, rewards);
		aManager.add(affecter);
	}

}
