package it.polimi.ingsw.ps11.alpha.network.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {

	
	public void endTurn(String id) throws RemoteException;
	
	
	
	//Se si potesse ottenere le informazioni della connessione nell'rmi non sarebbe necessario l'id...
	//public void familyInFloor(String id,FamilyMember familyMember, Tower tower , int floor);
	
	//Per ora proseguiamo con poche funzioni
	//public void familyInMarket(String id,FamilyMember familyMember);
	//public void familyInProduction(String id,FamilyMember familyMember);
	//public void familyInHarvest(String id,FamilyMember familyMember);
	
}
