package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.dices.DiceManager;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class DiceView extends ViewComponent {

	protected DiceManager dices;
	
	public void update(DiceManager dices) {
		this.dices = dices;
	}
	
}
