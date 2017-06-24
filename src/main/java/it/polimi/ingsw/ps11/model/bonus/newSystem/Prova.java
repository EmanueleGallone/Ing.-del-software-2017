package it.polimi.ingsw.ps11.model.bonus.newSystem;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.list.IncrementResourceAction;

public class Prova  extends Bonus<IncrementResourceAction>{

	@Override
	public void affectPerform(IncrementResourceAction action) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Prova prova = new Prova();
		prova.setObservers(null);
	}
}
