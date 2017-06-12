package it.polimi.ingsw.ps11.alpha.server;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public interface RemoteServer {

	//Si connette al server e ritorna l'id che da quel momento sara' associato al proprio client
	public String connect();
	
	//Se si potesse ottenere le informazioni della connessione nell'rmi non sarebbe necessario l'id...
	public void familyInFloor(String id,FamilyMember familyMember, Tower tower , int floor);
	public void familyInMarket(String id,FamilyMember familyMember);
	public void familyInProduction(String id,FamilyMember familyMember);
	public void familyInHarvest(String id,FamilyMember familyMember);
	public void endTurn(String id);
	
}
