package it.polimi.ingsw.ps11.network.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Lobby{
	private final int MAX_SIZE = 4;
	private final int START_SIZE = 2;
	private int i =0;
	private long delay = 60000; //va caricato da file
	Timer timer = new Timer();
	private Server server;

	private HashMap<String, GameConnection> clients = new HashMap<String, GameConnection>();
	
	public Lobby(Server server) {
		this.server = server;
	}
	
	public void addClient(String playerName,GameConnection client){
		clients.put(playerName, client);
		if(clients.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
		if(clients.size() == START_SIZE){
			System.out.println(START_SIZE + " giocatori connessi...");
			System.out.println("Inizializzo la Partita, aggiungere fino a "+ (MAX_SIZE-START_SIZE) + " altri giocatori entro " + (delay/1000) + " secondi");
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);		
		}
	}
	
	private void newMatch() {
		Match match = new Match(clients, i, server);
		clients = new HashMap();
		new Thread(match).start();
		i++;
	}
	
	class StartingMatch extends TimerTask{
		@Override
		public void run() {
			newMatch();
		}
		
	}

}
