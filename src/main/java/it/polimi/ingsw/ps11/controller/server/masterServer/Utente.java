package it.polimi.ingsw.ps11.controller.server.masterServer;

import it.polimi.ingsw.ps11.controller.client.RemoteClient;
import it.polimi.ingsw.ps11.model.player.Player;

public class Utente {
	
	private Player player;
	private RemoteClient client;
	
	public Utente(RemoteClient client , Player player) {
		this.player = player;
		this.client = client;
	}
	
	public Player getPlayer() {
		return player;
	}
	public RemoteClient getClient() {
		return client;
	}

}
