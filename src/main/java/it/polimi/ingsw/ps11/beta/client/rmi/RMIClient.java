package it.polimi.ingsw.ps11.beta.client.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.Client;
import it.polimi.ingsw.ps11.beta.client.ClientInterface;
import it.polimi.ingsw.ps11.beta.server.rmi.ConnectionServer;
import it.polimi.ingsw.ps11.beta.server.rmi.RMIRemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public class RMIClient extends Client {

	public RMIClient(View view) {
		super(view, new RMIRemoteServer());
	}

	@Override
	public void start() throws InternalError{
		try {
			System.out.println("Sono il client");
			RMIClientInterface client = new RMIRemoteClient();
			ConnectionServer serverMaster = (ConnectionServer) Naming.lookup(serverAddress);
			//UnicastRemoteObject.exportObject(client,0);
			//serverMaster.connect(client);
			System.out.println("Mi sono connesso");
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new InternalError(e);
		}
	}
}
