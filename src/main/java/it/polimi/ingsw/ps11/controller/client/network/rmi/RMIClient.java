package it.polimi.ingsw.ps11.controller.client.network.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.controller.client.Client;
import it.polimi.ingsw.ps11.controller.server.network.rmi.ConnectionServer;
import it.polimi.ingsw.ps11.controller.server.network.rmi.RMIRemoteServer;
import it.polimi.ingsw.ps11.view.textualView.TextualView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;


public class RMIClient extends Client {
	
	private final static String DEFAULT_SERVER =  "//localhost/myServer";
	
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
			//connectionServer.connect(remoteServer);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("Client connected to server");
	}
	
	public static void main(String[] args) {
		RMIClient client = new RMIClient(new TextualView());	
		new Thread(client).start();
	}

}
