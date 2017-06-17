package it.polimi.ingsw.ps11.controller.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public interface ClientInterface extends Remote{

	// Method that server can call on the client
	public void print(String message) throws RemoteException;
	public void startGame(Game game, Player player) throws RemoteException;
	
	public void update(Player player) throws RemoteException;

}
