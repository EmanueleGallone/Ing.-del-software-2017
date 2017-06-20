package it.polimi.ingsw.ps11.controller.server.masterServer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.controller.client.RemoteClient;
import it.polimi.ingsw.ps11.controller.message.Message;
import it.polimi.ingsw.ps11.controller.server.gameServer.GameController;

public class ConnectionHandler {
	
	private final int MAX_SIZE = 4; 
	private final int START_SIZE = 2;
	private long delay = 2000; //60000; //va caricato da file
	Timer timer;
	
	
	private ArrayList<RemoteClient> lobby = new ArrayList<>();
	private ArrayList<GameController> games = new ArrayList<>();
	
	public ConnectionHandler() {
		
	}
	
	public void handle(RemoteClient client) {
		try {
			client.send(new Message("Connesso, in attesa di giocatori"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		add(client);
	}
	
	public synchronized void add(RemoteClient client){
		
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
		GameController game = new GameController(lobby);
		lobby = new ArrayList<>();
		this.games.add(game);
		new Thread(game).start(); 
	}
	
	class StartingMatch extends TimerTask{

		@Override
		public void run() {
			newMatch();
		}
		
	}
}
