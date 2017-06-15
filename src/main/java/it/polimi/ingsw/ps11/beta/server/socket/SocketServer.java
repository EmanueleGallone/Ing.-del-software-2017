package it.polimi.ingsw.ps11.beta.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import it.polimi.ingsw.ps11.beta.client.socket.RemoteSocketClient;
import it.polimi.ingsw.ps11.beta.server.Server;

public class SocketServer extends Server {

	private ServerSocket serverSocket;
	
	public SocketServer(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public SocketServer(String serverAddress) {
		super(serverAddress,DEFAULT_PORT);
	}
	
	public SocketServer(String serverAddress, int port) {
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
