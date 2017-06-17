package it.polimi.ingsw.ps11.model.bonus;

import it.polimi.ingsw.ps11.model.game.actionsEma.EnableProductionAction;

public class EnableProductionBonus extends PlayerBonus {
	
	private int productionActiveValue;
	
	public EnableProductionBonus(int productionActiveValue) {
		this.productionActiveValue = productionActiveValue;
	}

	@Override
	public void behavior() {
		new EnableProductionAction(getPlayer(), this.productionActiveValue).perform();
	}
	
	public int getProductionActiveValue() {
		return productionActiveValue;
	}
	
	

}