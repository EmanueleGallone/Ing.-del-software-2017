package it.polimi.ingsw.ps11.controller.server;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.controller.server.gameServer.GameController;
import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.loaders.Loader;
/**
 * <h3> ConnectionHandler. </h3>
 * <p> Classe che gestisce la lobby del server, contiene il numero minimo e massimo dei giocatori per partita e un delay per la connessione
 * di giocatori oltre la sogglia minima.</p>
 */
public class ConnectionHandler {
	
	private final int MAX_SIZE = 4; 
	private final int START_SIZE = 2;
	private long delay = 30000;  //Viene caricato da file, tempo di attesa prima che una partita cominci dopo aver raggiunto i 2 giocatori
	private Timer timer;
	
	private ArrayList<Connection> lobby = new ArrayList<>();
	private ArrayList<GameController> games = new ArrayList<>();
	
	public ConnectionHandler() {
		try {
			delay = new Loader(FileRegistry.timers_lobby).load(Integer.class);
		} catch (FileNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
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
	
	public void checkPresenceInLobby(Connection connection){
		for(int i = 0; i<lobby.size();i++){
			Connection c = lobby.get(i);
			if(c.getId().equals(connection.getId())){
				lobby.remove(c);
				c.send("Another player has Logged in with your credentials. Log Out.");
			}
		}
	}
	
	public synchronized void addToLobby(Connection client){
	
		checkPresenceInLobby(client);
		client.send("Connected, waiting for other players...");
		
		lobby.add(client);
		System.out.println("  -> New " + client.getClass().getSimpleName() + "  there are:   " + lobby.size() + " clients in the lobby");
		if(lobby.size() == START_SIZE){
			timer = new Timer();
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);
			System.out.println("Timer started, the game will start in " + delay/1000 + " seconds ");
		}
		
		if(lobby.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
	}
	
	
	private synchronized void newMatch() {
		System.out.println("A new game has started");
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
