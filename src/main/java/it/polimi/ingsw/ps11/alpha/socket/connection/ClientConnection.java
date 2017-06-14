package it.polimi.ingsw.ps11.alpha.socket.connection;

import java.net.Socket;

import it.polimi.ingsw.ps11.alpha.socket.client.messages.ClientMessage;
import it.polimi.ingsw.ps11.alpha.socket.server.messages.ServerMessage;

public class ClientConnection extends Connection<ClientMessage<?>,ServerMessage<?> > {

	public ClientConnection(Socket socket) {
		super(socket);
	}
}
