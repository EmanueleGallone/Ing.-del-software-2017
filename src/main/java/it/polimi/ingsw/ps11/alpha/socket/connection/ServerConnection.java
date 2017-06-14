package it.polimi.ingsw.ps11.alpha.socket.connection;

import it.polimi.ingsw.ps11.alpha.socket.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.alpha.socket.server.messages.ServerMessage;

public class ServerConnection extends Connection<ClientMessage<?>, ServerMessage<?>> {
	public ServerConnection() {
		super();
	}
	
	public ServerConnection(String server) {
		super(server, DEFAULT_PORT);
	}

	public ServerConnection(String server, int port ) {
		super(server,port);
	}
}
