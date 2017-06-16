package it.polimi.ingsw.ps11.beta.server.rmiNew;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.polimi.ingsw.ps11.beta.client.rmiNew.RMIClientInterface;
import it.polimi.ingsw.ps11.beta.client.rmiNew.RMIRemoteClient;
import it.polimi.ingsw.ps11.beta.server.ServerMaster;

public class RMIServer extends ServerMaster implements ConnectionServer{

	public RMIServer() throws RemoteException {
		super();
	}

	@Override
	public void on() throws InternalError {
		 try {
			  Registry registry = LocateRegistry.createRegistry(1099);
			  registry.rebind("myServer", this);
			  System.out.println("Server partito");
		  } catch (RemoteException e) {
				//e.printStackTrace();
				throw new InternalError(e);
		  }
	}

	@Override
	public void connect(RMIClientInterface client) throws RemoteException {
		System.out.println("nuova connessione");
		RMIRemoteServer server = new RMIRemoteServer(client);
		client.setRemoteServer(server);
		RMIRemoteClient trueClient = new RMIRemoteClient();
		//trueClient.setRemoteServer(server);
		//this.connectionHandler.handle(trueClient);
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
