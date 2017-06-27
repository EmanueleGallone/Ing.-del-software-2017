package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;

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
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		//deve esserci override per il posizionamento del familiare su quale spazio azione
		return super.placeFamilyMember(familyMember, player);
	}	
	
}
