package it.polimi.ingsw.ps11.controller.server;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.server.masterServer.ConnectionHandler;
import it.polimi.ingsw.ps11.controller.server.network.rmi.RMIServer;
import it.polimi.ingsw.ps11.controller.server.network.socket.SocketServer;

public class MainServer {
	
	public static void main(String[] args) {
		try {
			ConnectionHandler connectionHandler = new ConnectionHandler();
			RMIServer rmiServer = new RMIServer(connectionHandler);
			SocketServer socketServer = new SocketServer(connectionHandler);
			new Thread(rmiServer).start();
			socketServer.run();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
