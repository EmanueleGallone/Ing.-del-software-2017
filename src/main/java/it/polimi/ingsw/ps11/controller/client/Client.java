package it.polimi.ingsw.ps11.controller.client;

import it.polimi.ingsw.ps11.controller.server.events.PrintEvent;
import it.polimi.ingsw.ps11.controller.server.events.StartGameEvent;
import it.polimi.ingsw.ps11.controller.server.events.UpdatePlayerEvent;
import it.polimi.ingsw.ps11.controller.server.network.RemoteServer;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public abstract class Client implements Runnable {
	
	private View view;
	protected RemoteServer server;
	
	public Client(View view) {
		this.view = view;
	}

	
	public abstract void start() throws InternalError;
	
	@Override
	public void run() {
		this.start();
	}
	
	protected void attachListener(){
		server.printEvent(printListener);
		server.updatePlayerEvent(updatePlayerListener);
		server.startGameEvent(startGameListener);
	}
	
	public void temp (Game game, Player player){
		//Questa funzione serve solo per fare qualche test senza il network
		startGameListener.handle(new StartGameEvent(game, player));
	}
	
	private EventListener<PrintEvent> printListener = new EventListener<PrintEvent>() {
		
		@Override
		public void handle(PrintEvent e) {
			view.out(e.getMessage());
		}
	};
	
	private EventListener<StartGameEvent> startGameListener = new EventListener<StartGameEvent>() {
		
		@Override
		public void handle(StartGameEvent e) {
			view.update(e.getPlayer());
			view.update(e.getGame());
			view.print();
		}
	};
	
	
	private EventListener<UpdatePlayerEvent> updatePlayerListener = new EventListener<UpdatePlayerEvent>() {
		
		@Override
		public void handle(UpdatePlayerEvent e) {
			
		}
	};
	
	
}
