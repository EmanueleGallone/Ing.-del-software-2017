package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
/** <h3> Confirm event </h3>
 * <p> Classe evento che gestisce la conferma dell'azione di posizionamente di un familiare su un actionSpace</p>
 */
public class ConfirmEvent extends ModelEvent {

	private Floor floor;
	private String tower;
	
	
	public ConfirmEvent(String message){
		super(message);
	}
	
	public ConfirmEvent(ActionSpace space){
		floor = new Floor();
		floor.setActionSpace(space);
	}
	
	public ConfirmEvent(Floor floor, String tower) {
		this.floor = floor;
		this.tower = tower;
	}
	
	public String getTower() {
		return tower;
	}
	
	public Floor getFloor() {
		return floor;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

	@Override
	public ConfirmEvent clone() {
		ConfirmEvent copy = new ConfirmEvent(floor.clone(), tower);
		if(getReceiver()!=null)
			copy.setReceiver(getReceiver().clone());
		copy.setMessage(getMessage());
		return copy;
	}

}
