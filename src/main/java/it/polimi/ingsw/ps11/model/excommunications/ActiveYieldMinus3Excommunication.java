package it.polimi.ingsw.ps11.model.excommunications;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ActiveYieldEffect;

public class ActiveYieldMinus3Excommunication extends Excommunication {
	
	public ActiveYieldMinus3Excommunication(Class<YellowCard> class1) {
		this.period = 1;
	
	}

	@Override
	public ActiveYieldMinus3Excommunication clone() {
		
		return null;
	}

}
