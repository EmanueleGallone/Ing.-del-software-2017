package it.polimi.ingsw.ps11.network.server;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public interface GameControllerInterface {

	public void familyInFloor(FamilyMember familyMember, Tower tower , int floor);
	public void familyInMarket(FamilyMember familyMember);
	public void familyInProduction(FamilyMember familyMember);
	public void familyInHarvest(FamilyMember familyMember);
	public void endTurn();
}
