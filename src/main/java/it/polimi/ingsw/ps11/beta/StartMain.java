package it.polimi.ingsw.ps11.beta;

import java.rmi.RemoteException;

import it.polimi.ingsw.ps11.beta.server.rmi.RMIServer;

public class StartMain {
	

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
