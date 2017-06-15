package it.polimi.ingsw.ps11.beta.client;

import it.polimi.ingsw.ps11.beta.server.RemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public abstract class Client implements Runnable {
	
	private View view;
	protected RemoteServer server;
	
	protected String serverAddress;
	protected int port;
	
	
	public Client(View view, RemoteServer server) {
		this.view = view;
		this.server = server;
	}

	
	public abstract void start();
	
	@Override
	public void run() {
		this.start();
	}
	
}
