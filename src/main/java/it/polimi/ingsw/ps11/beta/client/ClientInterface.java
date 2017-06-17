package it.polimi.ingsw.ps11.beta.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

public interface ClientInterface extends Remote{

	// Method that server can call on the client
	public void print(String message) throws RemoteException;
	public void startGame(Game game, Player player) throws RemoteException;
	
	public void update(Player player) throws RemoteException;

}
