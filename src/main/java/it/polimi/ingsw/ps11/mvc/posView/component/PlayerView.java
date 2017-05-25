package it.polimi.ingsw.ps11.mvc.posView.component;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class PlayerView {

	public void printStatus(Player player){
		System.out.println("STATUS: \n" + player.toString());
	}
}
