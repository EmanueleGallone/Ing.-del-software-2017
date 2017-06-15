package it.polimi.ingsw.ps11.beta.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Server extends UnicastRemoteObject implements Runnable, Serializable {
	
	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	protected int port;
	protected String serverAddress;
	
	protected transient ConnectionHandler connectionHandler = new ConnectionHandler();
	
	public Server() throws RemoteException{
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public Server(String serverAddress) throws RemoteException {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public Server(String serverAddress, int port) throws RemoteException {
		this.port = port;
		this.serverAddress = serverAddress;
	}
	
	public abstract void on() throws InternalError;
	
	@Override
	public void run() {
		on();
	}
}
