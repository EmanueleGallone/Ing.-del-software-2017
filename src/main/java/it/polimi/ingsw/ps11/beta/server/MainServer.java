package it.polimi.ingsw.ps11.beta.server;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.server.network.rmi.RMIServer;
import it.polimi.ingsw.ps11.beta.server.network.socket.SocketServer;

public class MainServer {
	
	public static void main(String[] args) {
		try {
			RMIServer rmiServer = new RMIServer();
			SocketServer socketServer = new SocketServer();
			new Thread(rmiServer).start();
			socketServer.run();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
