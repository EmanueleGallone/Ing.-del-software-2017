package it.polimi.ingsw.ps11.alpha.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import it.polimi.ingsw.ps11.alpha.client.RemoteClient;
import it.polimi.ingsw.ps11.alpha.client.socket.SocketClient;
import it.polimi.ingsw.ps11.alpha.server.Server;

public class SocketServer extends Server{

	private ServerSocket serverSocket;
	
	public SocketServer(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public SocketServer(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public SocketServer(String serverAddress, int port) {
		super(serverAddress,port);
	}
// _________________________________
	
	@Override
	public void on() throws InternalError{
		try {
			serverSocket = new ServerSocket(getPort());
			listen();
		} catch (IOException e) {
			throw new InternalError(e);
		}
	}
	
	
	private void listen() throws IOException{
		while (true) {
			Socket socket = serverSocket.accept();
			
			RemoteClient client = new SocketClient();
			
			
			//connectionHandler.handle();
		}
	}
	
	
	private void handleNewConnection(){
		
	}
//__________________________________

	@Override
	public void connect(RemoteClient client){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTurn(String id) {
		// TODO Auto-generated method stub
		
	}
}
