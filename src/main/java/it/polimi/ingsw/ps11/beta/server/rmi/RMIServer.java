package it.polimi.ingsw.ps11.beta.server.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.beta.client.rmi.RMIRemoteClient;
import it.polimi.ingsw.ps11.beta.server.Server;

public class RMIServer extends Server implements ConnectionServer {

	private HashMap<RMIRemoteServer, RMIRemoteClient> clients = new HashMap<>();
	
	@Override
	public void on() throws InternalError {
	  try {
		
		  Naming.rebind(serverAddress,this);
		
	  } catch (RemoteException | MalformedURLException e) {
			//e.printStackTrace();
			throw new InternalError(e);
	  }
	}

	@Override
	public void connect(RMIRemoteClient client) throws RemoteException {
		connectionHandler.handle(client);
	}

}
