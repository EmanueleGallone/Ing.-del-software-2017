package it.polimi.ingsw.ps11.beta.client.network.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.function.Consumer;

import it.polimi.ingsw.ps11.beta.client.events.EndTurnEvent;
import it.polimi.ingsw.ps11.beta.client.network.RemoteClient;
import it.polimi.ingsw.ps11.beta.server.network.rmi.RMIServerInterface;
import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class RMIRemoteClient extends RemoteClient implements RMIClientInterface, Serializable {

	private RMIServerInterface server;
	
	public RMIRemoteClient() throws RemoteException {
		super();
	}
	
	public RMIRemoteClient(RMIServerInterface serverInterface) throws RemoteException {
		super();
		this.server = serverInterface;
	}

// Metodi che il server puo' chiamare sul client
	
	@Override
	public void print(String message){
		call(s -> {try {
			s.invokePrintEvent(message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}});
	}
	
	@Override
	public void update(Player player){
		call(s -> {try {
			s.invokeUpdate(player);
		} catch (RemoteException e) {
			e.printStackTrace();
		}});
	}
	
	@Override
	public void startGame(Game game, Player player) throws RemoteException {
		call(s -> {try {
			s.invokeStartGame(game, player);
		} catch (RemoteException e) {
			e.printStackTrace();
		}});
	}
	
// Metodi/Eventi che il client puo' chiamare

	@Override
	public void setRemoteServer(RMIServerInterface server) throws RemoteException {
		this.server = server;
	}

	@Override
	public void invokeEndTurnEvent() throws RemoteException {
		this.endTurnEvent.invoke(new EndTurnEvent());
	}
	
	
	
// Oggetto che si occupera di chiamare i metodi RMI in caso debbano essere asincroni
	
	private void call(Consumer<? super RMIServerInterface> action){
		// Serve a rendere le chiamate RMI asincrone
		new Caller(server).call(action);
	}
	
	class Caller implements Runnable{
		RMIServerInterface server;
		Consumer<? super RMIServerInterface> action;
		
		public Caller(RMIServerInterface server) {
			this.server = server;
		}
		
		public void call(Consumer<? super RMIServerInterface> action){
			this.action = action;
			new Thread(this).start();
		}

		@Override
		public void run() {
			action.accept(server);
		}
	}
}
