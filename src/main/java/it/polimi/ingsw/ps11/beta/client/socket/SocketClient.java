package it.polimi.ingsw.ps11.beta.client.socket;

import java.io.IOException;
import java.net.UnknownHostException;

import it.polimi.ingsw.ps11.beta.client.Client;
import it.polimi.ingsw.ps11.beta.server.socket.RemoteSocketServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public class SocketClient extends Client {
	
	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	
	public SocketClient(View view) throws UnknownHostException, IOException {
		this(view, DEFAULT_SERVER, DEFAULT_PORT );
	}
	
	public SocketClient(View view, String serverAddress, int port) throws UnknownHostException, IOException {
		super(view, new RemoteSocketServer(serverAddress,port));
	}

	public SocketClient(View view, RemoteSocketServer server) {
		super(view, server);
	}

	@Override
	public void start() {
		
	}
	
	
}
