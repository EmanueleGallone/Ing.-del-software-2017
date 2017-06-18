package it.polimi.ingsw.ps11.controller.server.masterServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.controller.client.network.RemoteClient;

public abstract class Server extends UnicastRemoteObject implements Runnable {
	
	private static final long serialVersionUID = -4802806597261913213L;
	
	private ConnectionHandler connectionHandler = new ConnectionHandler();
	
	public Server() throws RemoteException{
		
	}
	
	public Server(ConnectionHandler connectionHandler) throws RemoteException{
		this.connectionHandler = connectionHandler;
	}
	
	public abstract void on() throws InternalError;
	
	protected void handleConnection(RemoteClient client){
		connectionHandler.handle(client);
	}
	
	@Override
	public void run() {
		on();
	}

	protected void consoleLog(String message){
		System.out.println(message);
	}
}
