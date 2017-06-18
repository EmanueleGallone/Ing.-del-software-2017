package it.polimi.ingsw.ps11.controller.server.network.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.polimi.ingsw.ps11.controller.client.network.rmi.RMIRemoteClient;
import it.polimi.ingsw.ps11.controller.server.masterServer.ConnectionHandler;
import it.polimi.ingsw.ps11.controller.server.masterServer.Server;

public class RMIServer extends Server implements ConnectionServer{

	protected int port = 1099;
	protected String serverName = "myServer";
	
	public RMIServer() throws RemoteException {
		super();
	}

	public RMIServer(ConnectionHandler connectionHandler) throws RemoteException {
		super(connectionHandler);
	}
	
	public RMIServer(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}
	
	public RMIServer(String serverName, int port) throws RemoteException {
		super();
		this.serverName = serverName;
		this.port = port;
	}
	
	@Override
	public void on() throws InternalError {
		 try {
			  Registry registry = LocateRegistry.createRegistry(port);
			  registry.rebind(serverName, this);
			  consoleLog("RMIServer started");
		  } catch (RemoteException e) {
				//e.printStackTrace();
				throw new InternalError(e);
		  }
	}

	@Override
	public void connect(RMIServerInterface remoteServer) throws RemoteException {
		RMIRemoteClient client = new RMIRemoteClient(remoteServer);	
		remoteServer.setClient(client);
		this.handleConnection(client);
	}
	

	public static void main(String[] args) throws RemoteException {
		Object lockObject = new Object();
		RMIServer server = new RMIServer();
		//startMain.server.on();
		new Thread(server).start();

		synchronized(lockObject){
            try {
				lockObject.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      }
	}

}
