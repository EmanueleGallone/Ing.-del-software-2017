package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ChooseFamilyView extends ViewComponent{
	
	protected String playerColor = new String();
	protected FamilyMemberManager familyManager = new FamilyMemberManager();
	
	public void update(FamilyMemberManager familyMemberManager) {
		this.familyManager = familyMemberManager;
	}

	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}

}
