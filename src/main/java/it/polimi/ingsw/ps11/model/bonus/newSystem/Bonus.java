package it.polimi.ingsw.ps11.model.bonus.newSystem;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionObserver;

public abstract class Bonus<T> implements ActionObserver<T>{

	
	public void setObservers(ActionManager actionManager){
		System.out.println(this.getClass());
	}

}
