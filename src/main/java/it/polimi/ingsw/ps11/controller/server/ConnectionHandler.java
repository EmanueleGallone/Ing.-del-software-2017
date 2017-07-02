package it.polimi.ingsw.ps11.controller.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.server.gameServer.GameController;

public class ConnectionHandler {
	
	private final int MAX_SIZE = 4; 
	private final int START_SIZE = 2;
	private long delay = 1000; //60000; //va caricato da file
	private Timer timer;
	
	private ArrayList<Connection> lobby = new ArrayList<>();
	private ArrayList<GameController> games = new ArrayList<>();
	
	public ConnectionHandler() {
		
	}
	
	public void handle(Connection client) {
		
		if(checkPresence(client))
			return;
		
		addToLobby(client);
	}
	
	
	/**
	 * Controlla se il giocatore era già in una partita, nel caso lo trovi aggiorna la connessione
	 */
	public boolean checkPresence(Connection connection){
		for(GameController controller : games){
			if(controller.search(connection))
				return true;
		}
		return false;
	}
	
	public synchronized void addToLobby(Connection client){
		try {
			client.send("Connesso, in attesa di altri giocatori");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lobby.add(client);
		System.out.println("  -> Nuovo " + client.getClass().getSimpleName() + "  ci sono:   " + lobby.size() + " client nella lobby");
		if(lobby.size() == START_SIZE){
			timer = new Timer();
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);
			System.out.println("Timer avviato, la partita iniziera' fra " + delay/1000 + " secondi ");
		}
		
		if(lobby.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
	}
	
	
	private synchronized void newMatch() {
		System.out.println("Avvio una nuova partita");
		GameController gameController = new GameController(lobby);
		lobby = new ArrayList<>();
		this.games.add(gameController);
		new Thread(gameController).start(); 
	}
	
	class StartingMatch extends TimerTask{

		@Override
		public void run() {
			newMatch();
		}
		
	}
}
