package it.polimi.ingsw.ps11.alpha.network.server;

public abstract class Server implements RemoteServer {

	protected static final int DEFAULT_PORT = 9999;
	protected static final String DEFAULT_SERVER = "localhost";
	private int port;
	private String serverAddress;
		
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
	
// _________________________________________
	
	
	public abstract void on() throws InternalError;
	
// Getters _________________________________
	
	public int getPort() {
		return port;
	}
	public String getServerAddress() {
		return serverAddress;
	}
	
	
}
