package it.polimi.ingsw.ps11.beta.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Server extends UnicastRemoteObject implements Runnable {
	
	private static final long serialVersionUID = -4802806597261913213L;
	
	protected transient ConnectionHandler connectionHandler = new ConnectionHandler();
	
	public Server() throws RemoteException{
		
	}
	
	public abstract void on() throws InternalError;
	
	@Override
	public void run() {
		on();
	}

	protected void consoleLog(String message){
		System.out.println(message);
	}
}
