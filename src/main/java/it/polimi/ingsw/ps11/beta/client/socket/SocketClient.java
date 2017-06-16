package it.polimi.ingsw.ps11.beta.client.socket;

import java.io.IOException;

import it.polimi.ingsw.ps11.beta.client.Client;
import it.polimi.ingsw.ps11.beta.server.socket.RemoteSocketServer;
import it.polimi.ingsw.ps11.mvc.view.View;

public class SocketClient extends Client {
	
	protected int port = 2099;
	protected String serverAddress = "192.168.1.67";
	
	public SocketClient(View view){
		super(view);
	}
	
	public SocketClient(View view, String serverAddress, int port) {
		super(view);
		this.serverAddress = serverAddress;
		this.port = port;
	}

	@Override
	public void start() throws InternalError {
		try {
			RemoteSocketServer remoteServer = new RemoteSocketServer(serverAddress, port);
			this.server = remoteServer;
			this.attachListener();
			remoteServer.connect();
			System.out.println("Socket client started");
		} catch (IOException e) {
			//e.printStackTrace();
			throw new InternalError(e);
		}
	}
	
	public static void main(String[] args) {
		SocketClient socketClient = new SocketClient(null);
		socketClient.start();
	}
	
	
}
