package it.polimi.ingsw.ps11.controller.server;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.controller.server.network.rmi.RMIServer;
import it.polimi.ingsw.ps11.controller.server.network.socket.SocketServer;

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
