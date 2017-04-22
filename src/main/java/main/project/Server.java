package main.project;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class Server {
	
	private final static int MAX_PLAYERS = 4;
	private GameLobbie gameLobbie;
	private ArrayList<Partita> gameLobbies = new ArrayList<>();

	private ArrayList<Client> clients = new ArrayList<>();
	
	public void Start(){
		
	}
	
	
	public void onConnect(){
		Client c = new Client();
		clients.add(c);
		
	}
	
	
	
}
