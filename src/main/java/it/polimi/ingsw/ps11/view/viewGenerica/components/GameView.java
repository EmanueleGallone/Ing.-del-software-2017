package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class GameView extends ViewComponent{
	
	private Game game;
	
	public void update(Game game){
		this.game = game;
	}
}
