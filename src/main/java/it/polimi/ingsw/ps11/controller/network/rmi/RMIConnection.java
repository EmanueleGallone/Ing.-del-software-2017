package it.polimi.ingsw.ps11.controller.network.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.network.socket.MessageArrivedEvent;
import it.polimi.ingsw.ps11.controller.server.network.rmi.ConnectionServer;

public class RMIConnection extends Connection implements RMIReceiver{

	private static String DEFAULT_ADDRESS = "//localhost/myServer";
	private RMIReceiver connection;
	
	public RMIConnection() {
		this(DEFAULT_ADDRESS);
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
			ConnectionServer connectionServer = (ConnectionServer) Naming.lookup(getServerAddress());
			UnicastRemoteObject.exportObject(this,getPort());
			connectionServer.connect(this);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			//e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	@Override
	public void send(Message message) throws IOException {
		//Va resa asincrona
		connection.receive(message);
	}

	@Override
	public void receive(Message message) throws RemoteException {
		messageListener.invoke(new MessageArrivedEvent(message));
	}

	@Override
	public void setConnection(RMIReceiver connection) throws RemoteException {
		this.connection = connection;
	}

}
