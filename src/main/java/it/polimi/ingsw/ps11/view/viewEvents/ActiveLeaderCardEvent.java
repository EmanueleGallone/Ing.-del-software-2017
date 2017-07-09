package it.polimi.ingsw.ps11.view.viewEvents;

public class ActiveLeaderCardEvent extends ViewEvent{

	private String name;
	
	public ActiveLeaderCardEvent(String cardName) {
		this.name = cardName;
	}
	
	public String getCardName() {
		return name;
	}
	
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
