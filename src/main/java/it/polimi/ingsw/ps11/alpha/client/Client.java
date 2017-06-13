package it.polimi.ingsw.ps11.alpha.client;

import it.polimi.ingsw.ps11.alpha.server.RemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public abstract class Client implements RemoteClient{
	
	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	private int port;
	private String serverAddress;
		
	
	protected RemoteServer server;
	protected View view;

	public Client(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public Client(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public Client(String serverAddress, int port) {
		this.port = port;
		this.serverAddress = serverAddress;
	}

//_____________________________________
	
	public abstract void on();
//_____________________________________

	
// Getters ____________________________
	
	public int getPort() {
		return port;
	}
	public String getServerAddress() {
		return serverAddress;
	}
}
