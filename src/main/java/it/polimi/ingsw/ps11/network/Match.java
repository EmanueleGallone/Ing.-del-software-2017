package it.polimi.ingsw.ps11.network;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class Match implements Runnable{
	private ArrayList<Client> clients;
	private Game game;
	
	public Match(ArrayList<Client> clients) {
		this.clients = clients;
		ArrayList<Player> players = new ArrayList<>();
		for(Client c : clients){
			players.add(c.getPlayer());
		}
		game = new Game(players);
	}

	@Override
	public void run() {
		game.startGame();
	}

}
