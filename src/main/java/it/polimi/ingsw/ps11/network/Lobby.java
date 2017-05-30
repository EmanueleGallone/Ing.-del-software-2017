package it.polimi.ingsw.ps11.network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Lobby{
	private final int MAX_SIZE = 4;
	private final int START_SIZE = 2;
	private int delay;
	Timer timer = new Timer();
	
	
	private ArrayList<Client> clients = new ArrayList<>();
	private Map<Socket, Client> clientSocket = new HashMap<Socket, Client>();
	
	public Lobby() {
		caricaTimeout(); //carica già in millisecondi
		System.out.println("Lobby creata; giocatori : " + clients.size());
	}
	
	public void addClient(Client client){
		clients.add(client);
		System.out.println("giocatore aggiunto! numero giocatori: " + clients.size());
		
		if(clients.size() == START_SIZE){
			TimerTask task = new StartingMatch();
			timer.schedule(task, delay);
			
			
		}
		
		if(clients.size() == MAX_SIZE){
			timer.cancel();
			newMatch();
		}
		
	}
	
	private void caricaTimeout(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("settings\\timeout.txt"));
			String temp = reader.readLine();
			this.delay = Integer.parseInt(temp) * 1000;
			
			
		} catch (IOException e) {
			e.printStackTrace();
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
