package it.polimi.ingsw.ps11.beta.server.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.network.rmi.RMIClientInterface;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

public interface RMIServerInterface extends Remote {

	//Metodi che ha solo l'RMIServer
	
	public void setClient(RMIClientInterface client) throws RemoteException;
	public void invokePrintEvent(String message) throws RemoteException;
	public void invokeUpdate(Player player) throws RemoteException;
	public void invokeStartGame(Game game, Player player) throws RemoteException;
}
