package it.polimi.ingsw.ps11.network.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.server.GameConnection;


public class Match implements Runnable{
	private HashMap<String, GameConnection> players = new HashMap<String, GameConnection>();
	private ServerController controller;
	private int idPartita;
	//private static final ;
	
	public Match(HashMap<String, GameConnection> players, int i, Server server) {
		idPartita = i;
		this.players = players;
		registerConnection();
		send("all", "Partita " + idPartita + " cominciata! Giocatori:" + players.keySet());
	}

	@Override
	public void run() {
	}
	
	public void send(String player, Object object){
		if (player.equals("all")) players.forEach((name, connection)->connection.send(object));
		else players.get(player).send(object);
	}
	
	public void registerConnection(){
		players.forEach((name, connection)->connection.startMatch(this));
	}
	
	public int getIdPartita() {
		return idPartita;
	}
	
	public Set<String> getPlayers() {
		return players.keySet();
	}

	public void activate(Object object) {		//da applicare il visitor pattern

	}

}
