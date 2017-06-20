package it.polimi.ingsw.ps11.controller.client.network.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.server.network.rmi.RMIServerInterface;

public class RMIRemoteClient implements RMIClientInterface, Serializable {

	private RMIServerInterface server;
	
	public RMIRemoteClient() throws RemoteException {
		super();
	}
	
	public RMIRemoteClient(RMIServerInterface serverInterface) throws RemoteException {
		super();
		this.server = serverInterface;
	}

	@Override
	public void send(Message message) throws RemoteException {
		//Andra resa asincrona
		server.receive(message);
	}

	@Override
	public void setRemoteServer(RMIServerInterface server) throws RemoteException {
		this.server = server;
	}

	@Override
	public void receive(Message message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

/*
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
*/
}
