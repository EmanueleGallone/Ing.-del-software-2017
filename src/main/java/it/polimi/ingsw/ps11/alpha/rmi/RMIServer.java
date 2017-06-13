package it.polimi.ingsw.ps11.alpha.rmi;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.alpha.network.client.RemoteClient;
import it.polimi.ingsw.ps11.alpha.network.server.Server;

public class RMIServer extends Server{
	
	private RMIServer rmiServer;

	public RMIServer() throws RemoteException {
		this(DEFAULT_SERVER,DEFAULT_PORT);
	}
	
	public RMIServer(String serverAddress) throws RemoteException {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public RMIServer(String serverAddress, int port) throws RemoteException {
		super(serverAddress,port);
	}
	
// ___________________________________
	
	@Override
	public void on() throws InternalError{
		try {
			//Non so bene come funziona questa parte dell'rmi
			rmiServer = new RMIServer();
			Naming.rebind(getServerAddress(),rmiServer);
		} catch (RemoteException | MalformedURLException e) {
			throw new InternalError(e);
		} 
	}
	
//____________________________________
	
	public void connect(RMIClient client) throws RemoteException {
		connectionHandler.handle(client);
	}

	@Override
	public void endTurn(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
