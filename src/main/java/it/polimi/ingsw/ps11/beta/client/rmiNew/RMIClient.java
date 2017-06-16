package it.polimi.ingsw.ps11.beta.client.rmiNew;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.beta.client.Client;
import it.polimi.ingsw.ps11.beta.server.rmiNew.ConnectionServer;
import it.polimi.ingsw.ps11.beta.server.rmiNew.RMIRemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public class RMIClient extends Client {
	
	
	public RMIClient(View view) {
		super(view,null);
	}

	@Override
	public void start() {
		System.out.println("Sono il client");
		
		try {
			ConnectionServer server = (ConnectionServer) Naming.lookup(serverAddress);
			RMIRemoteServer	s = new RMIRemoteServer();
			UnicastRemoteObject.exportObject(s,5263);
			server.connect(s);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("Mi sono connesso");
	}
	
	public static void main(String[] args) {
		RMIClient client = new RMIClient(null);
		
		new Thread(client).start();
		
	}

}
