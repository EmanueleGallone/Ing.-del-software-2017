package it.polimi.ingsw.ps11.cranio.actions.list;

import it.polimi.ingsw.ps11.cranio.actions.Action;

public class ProvaAction extends Action<ProvaAction> {

	public int sonoprova = 0;
	
	@Override
	public void perform() {
		performEvent(this);
	}

	@Override
	public boolean isLegal() {
		
		return false;
	}

}
