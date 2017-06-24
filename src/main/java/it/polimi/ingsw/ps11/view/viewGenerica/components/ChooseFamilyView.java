package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class ChooseFamilyView extends ViewComponent{
	
	protected FamilyMemberManager familyView;
	
	public void update(FamilyMemberManager familyMemberManager) {
		this.familyView = familyMemberManager;
	}

}