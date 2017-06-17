package it.polimi.ingsw.ps11.beta.server.masterServer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.beta.client.ClientInterface;
import it.polimi.ingsw.ps11.beta.client.network.RemoteClient;
import it.polimi.ingsw.ps11.beta.server.gameServer.GameController;

public class ConnectionHandler {
	
	private final int MAX_SIZE = 4; 
	private final int START_SIZE = 2;
	private long delay = 10000; //60000; //va caricato da file
	Timer timer;
	
	
	private ArrayList<RemoteClient> lobby = new ArrayList<>();
	private ArrayList<GameController> games = new ArrayList<>();
	
	private ArrayList<ClientInterface> clients = new ArrayList<>();
	
	
	public ConnectionHandler() {
		
	}
	
	public void handle(RemoteClient client) {
		try {
			client.print("Connesso, in attesa di altri giocatori");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		add(client);
	}
	
	public synchronized void add(RemoteClient client){
		
		lobby.add(client);
		System.out.println(lobby.size() + " client in lobby");
		if(lobby.size() == START_SIZE){
			timer = new Timer();
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);
			System.out.println("Timer avviato");
		}
		
		if(lobby.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
	}
	
	
	private synchronized void newMatch() {
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
