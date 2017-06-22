package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;

public class FamilySelectedEvent extends ViewEvent {

	private String familyMember;
	
	public FamilySelectedEvent(Player player, FamilyMember familyMember)  {
		// Posso evitare di passargli il player? Trovare un modo
		super(player);
		this.familyMember = familyMember.getClass().toString(); //CI sono alternative
	}

	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

	public String getFamilyMember() {
		return familyMember;
	}

}
