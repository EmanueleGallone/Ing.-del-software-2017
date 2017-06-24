package it.polimi.ingsw.ps11.model.bonus.ema.malus.secondPeriod;

import it.polimi.ingsw.ps11.model.bonus.ema.actionsEma.PlaceFamilyMarketAction;
import it.polimi.ingsw.ps11.model.bonus.ema.malus.ActionConditionAffecter;
import it.polimi.ingsw.ps11.model.bonus.ema.malus.Excommunication;

public class NoMoreMarket extends Excommunication implements ActionConditionAffecter {
	
	public NoMoreMarket(PlaceFamilyMarketAction action) {
		//non serve il player qui. è semplicemente un flag. vedi nella azione posiziona familiare nel market
	}

	@Override
	public void behaviour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean check() {
		
		return false;
	}

}
