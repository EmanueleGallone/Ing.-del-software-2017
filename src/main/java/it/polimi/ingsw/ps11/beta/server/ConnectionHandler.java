package it.polimi.ingsw.ps11.beta.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.beta.client.ClientInterface;
import it.polimi.ingsw.ps11.beta.client.RemoteClient;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.network.connection.Connection;
import it.polimi.ingsw.ps11.network.server.GameController;

public class ConnectionHandler implements Serializable {
	
	private final int MAX_SIZE = 4; 
	private final int START_SIZE = 2;
	private long delay = 10000; //60000; //va caricato da file
	Timer timer;
	
	
	private ArrayList<Connection> lobby = new ArrayList<>();
	private ArrayList<GameController> games = new ArrayList<>();
	
	private ArrayList<ClientInterface> clients = new ArrayList<>();
	
	
	public ConnectionHandler() {
		
	}
	
	public void handle(RemoteClient client) {
		System.out.println("Sono connection handler");
		try {
			client.print("Client scrivi ciao");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Connection connection){
		
		lobby.add(connection);
		connection.clientDisconnectEvent(disconnectionListener);
		System.out.println(lobby.size() + " client nella lobby");
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
	
	
	EventListener<Connection> disconnectionListener = new EventListener<Connection>() {

		@Override
		public void handle(Connection e) {
			lobby.remove(e);
			if (lobby.size()<START_SIZE && timer != null){
				timer.cancel();
				System.out.println("timer cancellato");
			}
		}
	};
	
	private void newMatch() {
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
