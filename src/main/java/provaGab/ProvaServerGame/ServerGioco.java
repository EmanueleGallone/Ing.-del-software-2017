package provaGab.ProvaServerGame;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerGioco {
		
	static final int PORT = 12345; //porta fissa per le connessioni

	private static final int MAX = 4;

	private static final int MIN = 2;
	
	//private boolean activeServer;
	private ServerSocket serverSocket;
	Socket newSocket;
	static ServerGioco server;
			
	private ExecutorService executor = Executors.newFixedThreadPool(128);						//il server regge 128 connessioni contemporanee 
																								//affidate ad altrettanti thread 
	
	Map<String, Client> waitingConnection = new HashMap<>();
	private ArrayList<Client> connections = new ArrayList<Client>();							//lista delle connessioni attualmente attive
	
	
	public static void main (String[] args){
		try {
			server = new ServerGioco(PORT);														//creo il server sulla porta
			//activeServer = true ;																deve supportare pi� partite contemporaneamente, da implementare poi
			//while(activeServer){
				server.run();																	//faccio partire il server
				//}
		} catch (IOException e) {
			System.err.println("Impossibile inizializzare il server: " + e.getMessage() + "!");
		}		
	}	


	
	public ServerGioco(int porta) throws IOException {
		this.serverSocket = new ServerSocket(porta);
	}
	
	
	
	public void run() {
		System.out.println("Server Inizializzato... \n\nConnettere i giocatori");
		while(true){
			//creo una connessione e la assegno ad un thread
			try {
				newSocket = serverSocket.accept();
				Client connection = new Client(newSocket, this, executor);								//passo alla connessione create il socket e il server
				registerConnection(connection);
				executor.submit(connection);				//Equivalente a new Thread(c).start();				//lo affido ad un thread
			} catch (IOException e) {
				System.err.println("Errore di connessione!");
			}
		}		
	}
	
	
	
	synchronized void registerConnection(Client c){										//da notare che sono synchronized,
		
		connections.add(c);
	}																	//posso essere chiamati da pi� thread insieme
	
	
	
	public synchronized void deregisterConnection(Client c){									//se una connessione termina, la tolgo dalla lista
			connections.remove(c);
			//Client enemy = playingConnection.get(c);											//se la connessione � associata ad una partita
			//if(enemy != null)															
			//playingConnection.remove(c);														//rimuove il giocatore che si � disconnesso
			//manda un messaggio di errore agli altri giocatori
			
	}

	
	
	public synchronized void waitingGame(Client c, String name){
		waitingConnection.put(name, c);
		System.out.println("Il giocatore " + name + " si � connesso.\n" + "Giocatori in Attesa: " + waitingConnection.size() );
		if(waitingConnection.size() == MIN) {
			Lobby GameLobby =  new Lobby (waitingConnection, this, serverSocket, MAX, MIN);
			executor.submit(GameLobby);
		}
		if(waitingConnection.size() > MIN) {
			Lobby.register(c, name);
			};
		notify();
		}	
}