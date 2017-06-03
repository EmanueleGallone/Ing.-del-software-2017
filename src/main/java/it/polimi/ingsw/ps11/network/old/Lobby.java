package it.polimi.ingsw.ps11.network.old;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import it.polimi.ingsw.ps11.network.newClient.Client;

public class Lobby{
	private final int MAX_SIZE = 4;
	private final int START_SIZE = 2;
	private long delay = 60000; //va caricato da file
	Timer timer = new Timer();
	
	
	private ArrayList<Client> clients = new ArrayList<>();
	
	public Lobby() {
	}
	
	public void addClient(Client client){
		clients.add(client);
		
		if(clients.size() == START_SIZE){
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);
			
			
		}
		
		if(clients.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
		
	}
	
	private void newMatch() {
		Match match = new Match(clients);
		clients = new ArrayList<>();
		new Thread(match).start(); 
	}
	
	class StartingMatch extends TimerTask{

		@Override
		public void run() {
			newMatch();
		}
		
	}

}
