package it.polimi.ingsw.ps11.network.newServer;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.network.Connection;
import it.polimi.ingsw.ps11.network.old.Match;

public class GamesManager {
	
	private final int MAX_SIZE = 4;
	private final int START_SIZE = 2;
	private int i = 0;
	private long delay = 60000; //va caricato da file
	Timer timer = new Timer();
	
	
	private ArrayList<Connection> lobby = new ArrayList<>();
	private ArrayList<GameController> games = new ArrayList<>();
	
	public GamesManager() {
	
	}
	
	public void add(Connection connection){
		
		lobby.add(connection);
		
		if(lobby.size() == START_SIZE){
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);
		}
		
		if(lobby.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
	}
	
	private void newMatch() {
		GameController game = new GameController(lobby);
		lobby = new ArrayList<>();
		new Thread(game).start(); 
	}
	
	class StartingMatch extends TimerTask{

		@Override
		public void run() {
			newMatch();
		}
		
	}
	
}
