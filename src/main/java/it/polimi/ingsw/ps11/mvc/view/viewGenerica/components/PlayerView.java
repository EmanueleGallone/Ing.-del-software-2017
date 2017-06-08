package it.polimi.ingsw.ps11.mvc.view.viewGenerica.components;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.ViewComponent;

public abstract class PlayerView extends ViewComponent {

	private Player player;
	
	public PlayerView(String id) {
		super(id);
	}
	
	public void update(Player player){
		this.player = player;
	}
	
}
