package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class PlayerView extends ViewComponent {

	protected Player player;
	
	protected ResourceView resourceView;
	protected PersonalBoardView personalBoard;
	
	public void update(Player player){
		this.player = player;
		resourceView.update(player.getResourceList());
		personalBoard.update(player.getCardManager());
	}
	
}
