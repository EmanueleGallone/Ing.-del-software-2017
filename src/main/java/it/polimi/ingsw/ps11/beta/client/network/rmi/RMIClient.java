package it.polimi.ingsw.ps11.beta.client.network.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.beta.client.Client;
import it.polimi.ingsw.ps11.beta.server.network.rmi.ConnectionServer;
import it.polimi.ingsw.ps11.beta.server.network.rmi.RMIRemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public class RMIClient extends Client {
	
	private final static String DEFAULT_SERVER =  "//192.168.1.67/myServer";
	
	protected String serverName;
	
	public RMIClient(View view) {
		this(view, DEFAULT_SERVER);
	}
	
	public RMIClient(View view , String serverName) {
		super(view);
		this.serverName = serverName;
	}

	@Override
	public void start() {
		System.out.println("RMI client started");
		try {
			ConnectionServer connectionServer = (ConnectionServer) Naming.lookup(serverName);
			RMIRemoteServer	remoteServer = new RMIRemoteServer();
			UnicastRemoteObject.exportObject(remoteServer,5263);
			this.server = remoteServer;
			this.attachListener();
			connectionServer.connect(remoteServer);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("Client connected to server");
	}
	
	public static void main(String[] args) {
		RMIClient client = new RMIClient(null);	
		client.start();
	}

}
