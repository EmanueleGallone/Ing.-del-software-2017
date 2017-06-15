package it.polimi.ingsw.ps11.beta.client;

import java.io.Serializable;

import it.polimi.ingsw.ps11.beta.client.rmi.RMIClient;
import it.polimi.ingsw.ps11.beta.server.RemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public abstract class Client implements Runnable,Serializable {
	
	private View view;
	protected RemoteServer server;
	
	protected String serverAddress = "//192.168.1.67/myServer";
	protected int port = 2099;
	
	
	public Client(View view, RemoteServer server) {
		this.view = view;
		this.server = server;
	}

	
	public abstract void start();
	
	@Override
	public void run() {
		this.start();
	}
	
	public static void main(String[] args) {
		RMIClient client = new RMIClient(null);
		
		new Thread(client).start();
		
	}
	
}
