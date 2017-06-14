package it.polimi.ingsw.ps11.alpha.network.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public interface ClientInterface extends Remote{
	
	public void out(String message) throws RemoteException;

	public void update(Game game) throws RemoteException;
	public void update(Board board) throws RemoteException;
	public void update(Player player) throws RemoteException;
}
