package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
/**
 * <h3> Market </h3>
 * <p> Classe che rappresenta la zona mercato del gioco con i relativi spazi in base al numero dei giocatori. </p>
 */
public class Market extends MultipleActionSpace implements Serializable  {
	
	private final int THRESHOLD = 2;
	private final int MAX_NUMBER = 4;
	private int playerNumber;
	
	public Market(int playerNumber) {
		this.playerNumber = playerNumber;		
	}
	
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	@Override
	public ActionSpace getActionSpace(int index) throws IllegalArgumentException {
	
		if (index < THRESHOLD && index >= 0 ) {
			return super.getActionSpace(index);
		}
		else if (playerNumber == MAX_NUMBER) {
			return super.getActionSpace(index);
		}
		
		throw new IllegalArgumentException();
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
//	/**<h3> boolean placeFamilyMember(familyMember, Player) </h3>
//	 *<p> Piazza il familiare sull'actionspace selezionato, se questo non è già occupato </p> 
//	 */
//	@Override
//	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
//		//deve esserci override per il posizionamento del familiare su quale spazio azione
//		return super.placeFamilyMember(familyMember, player);
//	}		
}
