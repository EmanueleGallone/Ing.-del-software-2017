package it.polimi.ingsw.ps11.network.old;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.network.newClient.Client;

public class Match implements Runnable{
	private ArrayList<Client> clients;
	private Game game;
	
	public Match(ArrayList<Client> clients) {
		this.clients = clients;
		ArrayList<Player> players = new ArrayList<>();
		for(Client c : clients){
			//players.add(c.getPlayer());
		}
		game = new Game(players);
	}

	@Override
	public void run() {
		game.startGame();
	}

}
