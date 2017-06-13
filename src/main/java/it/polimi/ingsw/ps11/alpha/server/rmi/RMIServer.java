package it.polimi.ingsw.ps11.alpha.server.rmi;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.alpha.client.RemoteClient;
import it.polimi.ingsw.ps11.alpha.server.Server;

public class RMIServer extends Server{

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
			RMIServer server = new RMIServer();
			Naming.rebind(getServerAddress(),server);
		} catch (RemoteException | MalformedURLException e) {
			throw new InternalError(e);
		} 
	}
	
//____________________________________
	
	@Override
	public void connect(RemoteClient client) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTurn(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
