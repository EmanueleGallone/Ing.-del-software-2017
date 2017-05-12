package ProvaServerGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Lobby implements Runnable {
	
	int timer = 60, counter = 0, MAX, MIN;
	ServerGioco serverG;
	ServerSocket serverSocket;
	Socket newSocket;
	
	private static Map<String, Client> Players = new HashMap<>();

	
	
	public Lobby(Map<String, Client> waitingConnection, ServerGioco serverG, ServerSocket serverSocket, int max, int min) {
		
		System.out.print("Lobby creata," +  waitingConnection.keySet()+ " giocatori connessi.");
		
		Players.putAll(waitingConnection);
		
		this.serverG = serverG;
		this.serverSocket = serverSocket;
		this.MAX = max;
		this.MIN = min;

	}	

	
	@Override
	public void run() {
		
		System.out.println("Avete "+ timer + " secondi per aggiungere altri " + (MAX-MIN) + " giocatori");
		
		try {
			while((Players.size()!=MAX)&&(counter<60)){
			TimeUnit.SECONDS.sleep(1);
			counter++;
			}
		} catch (InterruptedException e) {
			System.err.print("Errore nel timer");
		}
		
		synchronized(this) {
		
			Partita partita = new Partita(Players);
		
			Players.clear();
		
			serverG.waitingConnection.clear();
		}
	}
		
	
	
	public synchronized static void register(Client c, String name) {
		Players.put(name, c);
		System.out.println("Il giocatore " + name + " si è connesso.\n" + Players.size() + " giocatori connessi");	
		}
	
}

