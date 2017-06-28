package it.polimi.ingsw.ps11.model.modelEvents;

public class Conferma extends ModelEvent {

	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
