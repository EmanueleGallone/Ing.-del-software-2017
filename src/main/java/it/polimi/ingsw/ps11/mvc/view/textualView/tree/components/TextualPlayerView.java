package it.polimi.ingsw.ps11.mvc.view.textualView.tree.components;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.TextualComponent;

public class TextualPlayerView extends TextualComponent {

	private Player player;
	protected EventHandler<TextualPlayerView> printEvent = new EventHandler<>();
	
	public void printEvent(EventListener<TextualPlayerView> listener){
		printEvent.attach(listener);
	}
	
	public void update(Player player){
		this.player = player;
	}
	
	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
