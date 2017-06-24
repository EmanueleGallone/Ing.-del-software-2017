package it.polimi.ingsw.ps11.model.bonus.ema;

import it.polimi.ingsw.ps11.model.bonus.ema.actionsEma.EnableHarvestAction;

public class EnableHarvestBonus extends PlayerBonus {
	
	private int harvestActivationValue;
	
	public EnableHarvestBonus(int harvestActivationValue) {
		this.harvestActivationValue = harvestActivationValue;
	}

	@Override
	public void behavior() {
		new EnableHarvestAction(getPlayer(), this.harvestActivationValue).perform();
	}
	
	public int getHarvestActivationValue() {
		return harvestActivationValue;
	}

}
