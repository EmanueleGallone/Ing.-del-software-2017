package it.polimi.ingsw.ps11.cranio.bonus.permanent;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.observers.Observer;

public abstract class PermanentBonus implements Observer {

	protected Bonus effect;
	
	public PermanentBonus(Bonus effect) {
		this.effect = effect;
	}
	
	
}
