package it.polimi.ingsw.ps11.model.modelEvents;

public interface ModelListener {

	public void handle(GameStartedEvent gameStartedEvent);
	public void handle(TextualEvent textualEvent);
	public void handle(PlayerUpdateEvent playerUpdateEvent);
	public void handle(ConfirmEvent conferma);
	public void handle(ChooseResourceEvent chooseCost);
}
