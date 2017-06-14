package it.polimi.ingsw.ps11.beta.server;

public abstract class Server {
	
	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	protected int port;
	protected String serverAddress;
	
	protected ConnectionHandler connectionHandler = new ConnectionHandler();
	
	public Server(){
		this(DEFAULT_SERVER, DEFAULT_PORT);
	}
	
	public Server(String serverAddress) {
		this(serverAddress,DEFAULT_PORT);
	}
	
	public Server(String serverAddress, int port) {
		this.port = port;
		this.serverAddress = serverAddress;
	}
	
	public abstract void on() throws InternalError;
}
