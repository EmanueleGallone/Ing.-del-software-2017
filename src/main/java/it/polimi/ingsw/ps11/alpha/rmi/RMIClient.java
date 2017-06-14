package it.polimi.ingsw.ps11.alpha.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.alpha.network.client.Client;

public class RMIClient extends Client {

	private RMIServer server;
	
	public RMIClient() throws RemoteException {
		this(DEFAULT_SERVER,DEFAULT_PORT);
	}
	
	public RMIClient(String serverAddress) throws RemoteException {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public RMIClient(String serverAddress, int port) throws RemoteException {
		//super(new RMIServer(serverAddress,port));
	}
	
//________________________________
	
	@Override
	public void on() throws InternalError {
		try {
			UnicastRemoteObject.exportObject(this, DEFAULT_PORT);
		    server = (RMIServer) Naming.lookup (serverAddress);
		    server.connect(this);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new InternalError(e);
		}
	}
//________________________________
	
}
