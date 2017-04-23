package ProvaServerGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;


public class Lobby {
	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	int timer = 60, counter = 0;
	
	Socket newSocket;
	
	private static Map<String, Client> Players = new HashMap<>();

	public Lobby(Map<String, Client> waitingConnection, ServerGioco serverG, ServerSocket serverSocket, int max, int min, ExecutorService executor) {
		
		//inserire i due giocatori passati tra i player
		
		final Runnable addPlayers = new Runnable()  {
			
			public void run(){
		
		System.out.print("Lobby creata, aggiungere al MAX altri" + (max-min) + " giocatori\n Entro " + timer + " secondi ");

		try {
			counter = max - min;
			while(counter != 0){
				newSocket = serverSocket.accept();
				Client connection = new Client(newSocket, serverG);								//passo alla connessione create il socket e il server
				serverG.registerConnection(connection);
				executor.submit(connection);
				
				counter--;}
		} catch (IOException e) {
			System.err.println("Errore di connessione!");
		}
			}

		};
		
		final ScheduledFuture<?> thread = scheduler.schedule(addPlayers, 0, SECONDS); 		//fa partire dopo 0 secondi
		     scheduler.schedule(new Runnable() {
		       public void run() { thread.cancel(true); }									//cancella il thread dopo 60 secondi
		     }, 60 , SECONDS);
		     
		Partita partita = new Partita(Players);
		
	}
		 

	
	public static void Players(Client client, String name) {
		Players.put(name, client);		
	}
}
