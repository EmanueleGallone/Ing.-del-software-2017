package it.polimi.ingsw.ps11.beta.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.client.socket.RemoteSocketClient;
import it.polimi.ingsw.ps11.beta.server.ServerMaster;

public class SocketServer extends ServerMaster {

	private ServerSocket serverSocket;
	
	public SocketServer() throws RemoteException{
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public SocketServer(String serverAddress) throws RemoteException {
		super(serverAddress,DEFAULT_PORT);
	}
	
	public SocketServer(String serverAddress, int port) throws RemoteException {
		super(serverAddress,port);
	}
	
	
	@Override
	public void on() throws InternalError {
		try {
			serverSocket = new ServerSocket(port);
			listen();
		} catch (IOException e) {
			throw new InternalError(e);
		}
	}
	

	private void listen() throws IOException{
		while (true) {
			Socket socket = serverSocket.accept();
			RemoteSocketClient client = new RemoteSocketClient(socket);
			//Qua dovrebbe generare un thread e passargli il client
			connectionHandler.handle(client);
		}
	}

}
