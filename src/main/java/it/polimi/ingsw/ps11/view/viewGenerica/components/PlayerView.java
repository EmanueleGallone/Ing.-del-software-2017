package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class PlayerView extends ViewComponent {

	private Player player;
	
	public void update(Player player){
		this.player = player;
	}
	
}
