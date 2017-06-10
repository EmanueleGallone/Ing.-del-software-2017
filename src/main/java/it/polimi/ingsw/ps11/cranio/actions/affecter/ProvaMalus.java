package it.polimi.ingsw.ps11.cranio.actions.affecter;

import it.polimi.ingsw.ps11.cranio.actions.ActionObserver;
import it.polimi.ingsw.ps11.cranio.actions.list.ProvaAction;

public class ProvaMalus implements ActionObserver<ProvaAction>{

	@Override
	public void affectPerform(ProvaAction action) {
		action.sonoprova++;
	}




}
