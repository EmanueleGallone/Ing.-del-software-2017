package it.polimi.ingsw.ps11.view.textualView.components;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;

import it.polimi.ingsw.ps11.view.textualView.TextualConsole;
import it.polimi.ingsw.ps11.view.viewGenerica.components.ChooseFamilyView;

public class TextualChooseFamilyView extends ChooseFamilyView {
	//faccio la print che fa scegliere e poi chiama la selected che crea l'evento?
	
	public TextualChooseFamilyView() {
	
	}
	
	public TextualChooseFamilyView(FamilyMemberManager familyMemberManager) {
		update(familyMemberManager);
	}
	@Override
	public void print() {
		TextualConsole console = new TextualConsole();
		
		console.print("\nBlack family member (value " + familyView.getFamilyMember(BlackFamilyMember.class).getValue() + ")");
		console.print("\nOrange family member (value " + familyView.getFamilyMember(OrangeFamilyMember.class).getValue() + ")");
		console.print("\nWhite family member (value " + familyView.getFamilyMember(WhiteFamilyMember.class).getValue() + ")");
		console.print("\nNeutral family member (value " + familyView.getFamilyMember(BlackFamilyMember.class).getValue() + ")");
		console.println("");
	}

}
