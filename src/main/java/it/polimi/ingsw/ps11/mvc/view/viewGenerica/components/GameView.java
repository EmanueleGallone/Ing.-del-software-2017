package it.polimi.ingsw.ps11.mvc.view.viewGenerica.components;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.ViewComponent;

public abstract class GameView extends ViewComponent{
	
	private Game game;
	
	public void update(Game game){
		this.game = game;
	}
}
