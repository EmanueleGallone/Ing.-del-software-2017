package it.polimi.ingsw.ps11.controller.server.network.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.client.network.socket.RemoteSocketClient;
import it.polimi.ingsw.ps11.controller.server.masterServer.ConnectionHandler;
import it.polimi.ingsw.ps11.controller.server.masterServer.Server;

public class SocketServer extends Server {

	private static final long serialVersionUID = 3650920835279416315L;
	
	private ServerSocket serverSocket;
	protected int port = 2099;
	
	public SocketServer() throws RemoteException {
		super();
	}

	public SocketServer(ConnectionHandler connectionHandler) throws RemoteException {
		super(connectionHandler);
	}
	
	public SocketServer(int port) throws RemoteException {
		super();
		this.port = port;
	}
	
	
	@Override
	public void on() throws InternalError {
		try {
			serverSocket = new ServerSocket(port);
			consoleLog("SocketServer started");
			listen();
		} catch (IOException e) {
			throw new InternalError(e);
		}
	}
	

	private void listen() throws IOException{
		while (true) {
			Socket socket = serverSocket.accept();
			RemoteSocketClient client = new RemoteSocketClient(socket);
			this.handleConnection(client);
		}
	}

}
