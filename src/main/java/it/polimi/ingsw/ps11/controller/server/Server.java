package it.polimi.ingsw.ps11.controller.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIConnection;
import it.polimi.ingsw.ps11.controller.network.rmi.RMIReceiver;
import it.polimi.ingsw.ps11.controller.network.socket.SocketConnection;
import it.polimi.ingsw.ps11.controller.server.login.LogInHandler;
/**
 * <h3> . </h3>
 * <p> Classe che gestisce il server, con modalità sia Socket che RMI. Contiene un LogInHandler per la registrazione dei giocatori e 
 * e il salvataggio dei dati su file.</p>
 * @see 
 */
public class Server extends UnicastRemoteObject implements RMIReceiver,Runnable {
	
	//private ConnectionHandler connectionHandler = new ConnectionHandler();
	private LogInHandler logInHandler = new LogInHandler();
	private String serverName = "myServer";
	private int rmiPort = 1099;
	private int socketPort = 4099;
	
	public Server() throws RemoteException{
		
	}
	
	public Server(String serverName) throws RemoteException{
		this.serverName = serverName;
	}
	
	@Override
	public void run() {
		ServerSocket server;
		
		try {
			//Start RMI
			Registry registry = LocateRegistry.createRegistry(rmiPort);
			registry.rebind(serverName, this);
			consoleLog("• RMIServer started \n");
			
			//Start Socket
			server = new ServerSocket(socketPort);
			consoleLog("• SocketServer started \n");
			socketListen(server);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void socketListen(ServerSocket server) throws IOException{
		while (true) {
			Socket socket = server.accept();
			SocketConnection client = new SocketConnection(socket);
			logInHandler.handle(client);
		}
	}

	@Override
	public void connect(RMIReceiver connection) throws RemoteException {
		RMIConnection client = new RMIConnection(connection);
		UnicastRemoteObject.exportObject(client, rmiPort );
		connection.connect(client);
		logInHandler.handle(client);
	}
	
	protected void consoleLog(String message){
		System.out.print(message);
	}

	@Override
	public void receive(Message message) throws RemoteException {
		
	}
	
	public void setSocketPort(int socketPort) {
		this.socketPort = socketPort;
	}
	public void setRmiPort(int rmiPort) {
		this.rmiPort = rmiPort;
	}

	public static void main(String[] args) throws RemoteException {
		Server server = new Server();
		server.run();
	}
}
