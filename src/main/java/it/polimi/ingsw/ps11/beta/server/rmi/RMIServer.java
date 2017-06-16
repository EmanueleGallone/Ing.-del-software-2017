package it.polimi.ingsw.ps11.beta.server.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.polimi.ingsw.ps11.beta.client.ClientInterface;
import it.polimi.ingsw.ps11.beta.client.rmi.RMIRemoteClient;
import it.polimi.ingsw.ps11.beta.server.ServerMaster;
import it.polimi.ingsw.ps11.beta.server.ServerInterface;

public class RMIServer extends ServerMaster implements ConnectionServer {

	public RMIServer() throws RemoteException {
		super();
	}

	@Override
	public void on() throws InternalError {
	  try {
		  Registry registry = LocateRegistry.createRegistry(1099);
		  registry.rebind("myServer", this);
		  System.out.println("Server partito");
	  } catch (RemoteException e) {
			//e.printStackTrace();
			throw new InternalError(e);
	  }
	}

	@Override
	public void connect(ClientInterface client) throws RemoteException {
		System.out.println("c'e' una nuova connessione");
		ServerInterface interface1 = new RMIRemoteServer();
		//client.setRemoteServer(interface1);
		//connectionHandler.handle(client);
	}

}
