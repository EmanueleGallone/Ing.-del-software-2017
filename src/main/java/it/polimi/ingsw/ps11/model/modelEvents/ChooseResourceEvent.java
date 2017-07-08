package it.polimi.ingsw.ps11.model.modelEvents;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> ChooseResourceEvent </h3>
 * <p> Classe evento che gestisce la scelta della resourceList per il pagamento dei costi.</p>
 */
public class ChooseResourceEvent extends ModelEvent {

	private ArrayList<ResourceList> options;
	
	public ChooseResourceEvent(ArrayList<ResourceList> options) {
		this.options = options;
	}
	
	public ArrayList<ResourceList> getOptions() {
		return options;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

	@Override
	public ChooseResourceEvent clone() {
		ChooseResourceEvent copy = new ChooseResourceEvent(options);
		if(getReceiver()!=null)
			copy.setReceiver(getReceiver().clone());
		copy.setMessage(getMessage());
		return copy;
	}

}
