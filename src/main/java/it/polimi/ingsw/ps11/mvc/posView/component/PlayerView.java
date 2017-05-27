package it.polimi.ingsw.ps11.mvc.posView.component;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.posView.TextualComponent;

public class PlayerView implements TextualComponent {

	private Player player;

	public void update(Player player){
		this.player = player;
	}
	
	@Override
	public void print() {
		new Console().print(player.toString());
	}

	@Override
	public void select() {
		
	}
}
