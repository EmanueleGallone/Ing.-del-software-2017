package it.polimi.ingsw.ps11.controller.network.rmi;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.message.Message;
import it.polimi.ingsw.ps11.controller.network.message.MessageListener;
import it.polimi.ingsw.ps11.controller.network.message.TextualMessage;

public class RMIConnection extends Connection implements RMIReceiver,Serializable{

	private static String DEFAULT_ADDRESS = "//localhost/myServer";
	private RMIReceiver connection;
	
	public RMIConnection() {
		this(DEFAULT_ADDRESS);
	}
	
	public RMIConnection(int port) {
		super(DEFAULT_ADDRESS,port);
	}
	
	public RMIConnection(RMIReceiver connection) {
		this.connection = connection;
	}
	
	public RMIConnection(String serverAddress) {
		super(serverAddress);
	}
	
	public RMIConnection(String serverAddress, int port) {
		super(serverAddress,port);
	}
	
	@Override
	public void on() throws IOException {
		try {
			RMIReceiver connectionServer = (RMIReceiver) Naming.lookup(getServerAddress());
			UnicastRemoteObject.exportObject(this,getPort());
			connectionServer.connect(this);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			//e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	@Override
	public void send(Message message){
		new Sender(connection).send(message);
	}

	@Override
	public void receive(Message message) throws RemoteException {
		invokeMessageEvent(message);
	}

	@Override
	public void connect(RMIReceiver connection) throws RemoteException {
		this.connection = connection;
	}
	
	class Sender implements Runnable{
		private RMIReceiver connection;
		private Message message;
		
		public Sender(RMIReceiver connection2) {
			this.connection = connection2;
		}
		
		public void send(Message message){
			this.message = message;
			new Thread(this).start();
		}

		@Override
		public void run() {
			try {
				connection.receive(message);
			} catch (RemoteException e) {
				//e.printStackTrace();
				System.err.println("RMIConnection: The connection is closed");
			}
		}
	}

}
