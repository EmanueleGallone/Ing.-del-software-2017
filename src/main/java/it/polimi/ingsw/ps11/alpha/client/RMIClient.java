package it.polimi.ingsw.ps11.alpha.client;

import java.rmi.Naming;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.Board;

public class RMIClient implements ClientInterface {

	
	public RMIClient() {
		//Stampatore s = (Stampatore) Naming.lookup("//localhost/server");
	}
	
	
	@Override
	public void out(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Player player) {
		// TODO Auto-generated method stub
		
	}

}
