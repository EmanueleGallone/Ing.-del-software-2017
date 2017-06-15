package it.polimi.ingsw.ps11.beta.client.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.beta.client.Client;
import it.polimi.ingsw.ps11.beta.server.rmi.RMIRemoteServer;
import it.polimi.ingsw.ps11.beta.server.rmi.RMIServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public class RMIClient extends Client {

	public RMIClient(View view) {
		super(view, new RMIRemoteServer());
	}

	@Override
	public void start() throws InternalError{
		try {
			RMIRemoteClient client = new RMIRemoteClient();
			RMIServer serverMaster = (RMIServer) Naming.lookup(serverAddress);
			UnicastRemoteObject.exportObject(client,port);
			serverMaster.connect(client);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new InternalError(e);
		}
	}

}
