package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.zones.Floor;
/** <h3> Confirm event </h3>
 * <p> Classe evento che gestisce la conferma dell'azione di posizionamente di un familiare su un actionSpace</p>
 */
public class ConfirmEvent extends ModelEvent {

	private Floor floor;
	
	public Floor getFloor() {
		return floor;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
