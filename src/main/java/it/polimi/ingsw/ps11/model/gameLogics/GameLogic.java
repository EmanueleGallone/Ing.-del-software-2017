package it.polimi.ingsw.ps11.model.gameLogics;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
import it.polimi.ingsw.ps11.model.gameLogics.states.PlayState;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public class GameLogic implements Runnable{

	private Game game;
	HashMap<Player, StateHandler> playerStatus = new HashMap<>();
	
	public GameLogic(ArrayList<Player> players) {
		
		game = new Game(players);
		for(Player player : players){
			playerStatus.put(player, new StateHandler(this,player));
		}
	}


	public Game getGame() {
		return game;
	}
	
	public void attach(EventListener<ModelEventInterface> listener){
		for(StateHandler playerState : playerStatus.values()){
			playerState.attach(listener);
		}
	}
	
	public void nextPlayer(){
		for(StateHandler playerState : playerStatus.values()){
			playerState.nextState(new DefaultState());
		}
		Player player = game.getRoundManager().next();
		playerStatus.get(player).nextState(new PlayState());
	}

	@Override
	public void run() {
		nextPlayer();
		for(StateHandler playerState : playerStatus.values()){
			playerState.start();
		}
	}

// Handle events from view
	
	public void handle(ViewEventInterface viewEvent){
		playerStatus.get(viewEvent.getSource()).handle(viewEvent);
	}
}
