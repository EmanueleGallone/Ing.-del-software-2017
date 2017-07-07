package it.polimi.ingsw.ps11.model.zones.actionSpace;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
/** <h3> FamilyMemberSpace </h3>
 * <p> Classe che rappresenta lo spazio azione del gioco dove e' possibile posizionare il familiare. </p>
 */
public interface FamilyMemberSpace {
	
	/**
	 * <h3> placeFamilyMember(FamilyMember familyMember, Player player)</h3>
	 * <p>
	 * Metodo che permette di posizionare un familiare nell' ActionSpace e il settaggio del campo owner di quest'ultimo.
	 * </p>
	 * @param familyMember è il familiare da posizionare
	 * @param player è il giocatore proprietario del familiare
	 */
	public void placeFamilyMember(FamilyMember familyMember, Player player);
	public void clean();
}
