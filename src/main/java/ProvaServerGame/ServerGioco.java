package ProvaServerGame;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerGioco {
		
	private static final int PORT = 12345, MAX = 4, MIN = 2;										//porta fissa per le connessioni
	
	//private boolean activeServer;
	private ServerSocket serverSocket;
	
	ServerGioco server;
			
	private ExecutorService executor = Executors.newFixedThreadPool(128);						//il server regge 128 connessioni contemporanee 
																								//affidate ad altrettanti thread 
	
	private Map<String, Client> waitingConnection = new HashMap<>();
	private ArrayList<Client> connections = new ArrayList<Client>();									//lista delle connessioni attualmente attive
	
	
	public void main(String[] args) {
		try {
			server = new ServerGioco(PORT);														//creo il server sulla porta
			//activeServer = true ;																deve supportare più partite contemporaneamente, da implementare poi
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
		while(true){																			//creo una connessione e la assegno ad un thread
			try {
				Socket newSocket = serverSocket.accept();
				Client connection = new Client(newSocket, this);								//passo alla connessione create il socket e il server
				registerConnection(connection);
				executor.submit(connection);//Equivalente a new Thread(c).start();				//lo affido ad un thread
			} catch (IOException e) {
				System.err.println("Errore di connessione!");
			}
		}		
	}
	
	
	
	synchronized void registerConnection(Client c){										//da notare che sono synchronized,
		
		connections.add(c);
	}																	//posso essere chiamati da più thread insieme
	
	
	
	public synchronized void deregisterConnection(Client c){									//se una connessione termina, la tolgo dalla lista
			connections.remove(c);
			//Client enemy = playingConnection.get(c);											//se la connessione è associata ad una partita
			//if(enemy != null)															
			//playingConnection.remove(c);														//rimuove il giocatore che si è disconnesso
			//manda un messaggio di errore agli altri giocatori
			
	}

	
	
	public synchronized void waitingGame(Client c, String name){								//associa due giocatori e crea la lobby
		waitingConnection.put(name, c);
		if(waitingConnection.size() == MIN){
			Lobby newlobby = new Lobby(waitingConnection, server, serverSocket ,MAX, MIN, executor);
			waitingConnection.clear();
		
		}
	}	
}
