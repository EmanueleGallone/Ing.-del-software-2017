package it.polimi.ingsw.ps11.alpha.network.client;

import it.polimi.ingsw.ps11.alpha.network.server.RemoteServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public abstract class Client implements RemoteClient{
	
	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	protected int port;
	protected String serverAddress;
	
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
	
	public Client(RemoteServer server) {
		//this.server = server;
	}

//_____________________________________
	
	public abstract void on() throws InternalError;
//_____________________________________

}
