package it.polimi.ingsw.ps11.model.zones.actionSpace;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;

public interface FamilyMemberSpace {
	
	/**
	 * <h3> placeFamilyMember(FamilyMember familyMember, Player player)</h3>
	 * <p>
	 * Metodo che permette di posizionare un familiare nell' ActionSpace.
	 * </p>
	 * @param familyMember è il familiare da posizionare
	 * @param player è il giocatore proprietario del familiare
	 * @return <code><b>true</b></code> se lo spazio azione era libero, <code><b>false</b></code> altrimenti
	 */
	public boolean placeFamilyMember(FamilyMember familyMember, Player player);
}
